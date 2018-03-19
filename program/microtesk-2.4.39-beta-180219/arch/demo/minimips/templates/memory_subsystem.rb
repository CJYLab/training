#
# Copyright 2015-2018 ISP RAS (http://www.ispras.ru)
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

require_relative 'minimips_base'

#
# Description:
#
# This test template demonstrates how to generate test cases for the memory subsystem.
#
class MemorySubsystemTemplate < MiniMipsBaseTemplate

  def pre
    super

    buffer_preparator(:target => 'L1') {
      prepare t0, address
      lw t1, 0, t0
    }

    buffer_preparator(:target => 'L2') {
      prepare t0, address
      lw t1, 0, t0
    }

    memory_preparator(:size => 32) {
      prepare t0, address
      prepare t1, value
      sw t1, 0, t0
    }

    org 0x10000
  end

  def run
    sequence(
        :engines => {
            :memory => {:classifier => 'event-based',
                        :page_mask => 0x0fff,
                        :align => 4,
                        :count => 5}
        }) {
      lw s0, 0, t0 do situation('memory', :engine => :memory, :base => 'lw.address') end
      lw s1, 0, t1 do situation('memory', :engine => :memory, :base => 'lw.address') end
    }.run
  end

end
