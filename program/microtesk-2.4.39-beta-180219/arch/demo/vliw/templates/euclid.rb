#
# Copyright 2014 ISP RAS (http://www.ispras.ru)
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#   http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

require_relative 'vliw_base'

#
# Description:
#
# This test template demonstrates how MicroTESK can simulate the execution
# of a test program to predict the resulting state of a microprocessor
# design under test. The described program calculates the greatest common
# divisor of two 5-bit random numbers ([1..63]) by using the Euclidean
# algorithm.
#

class EuclidTemplate < VliwBaseTemplate

  def run
    trace "Euclidean Algorithm: Debug Output"

    # Values from [1..63], zero is excluded because there is no solution
    i = rand(1, 63)
    j = rand(1, 63)

    trace "\nInput parameter values: %d, %d\n", i, j
    vliw (addi r(4), r(0), i), (addi r(5), r(0), j)

    label :cycle
    trace "\nCurrent register values: $4 = %d, $5 = %d\n", gpr(4), gpr(5)
    vliw (beq r(4), r(5), :done), (move r(6), r(4))

    vliw (slt r(2), r(4), r(5)), nop
    vliw (bne r(2), r(0), :if_less), nop

    vliw (b :cycle), (sub r(4), r(4), r(5))

    label :if_less
    vliw (b :cycle), (sub r(5), r(5), r(4))

    label :done
    trace "\nResult stored in $6: %d", gpr(6)
  end

end
