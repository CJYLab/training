/*
 * Copyright (c) Institute for System Programming of the Russian Academy of Sciences
 * All Rights Reserved
 *
 * Institute for System Programming of the Russian Academy of Sciences (ISP RAS)
 * 25 Alexander Solzhenitsyn st., Moscow, 109004, Russia
 * http://www.ispras.ru
 *
 * The present file was automatically generated on the basis of formal specifications.
 * It is distributed under the same terms and conditions as the derived specifications.
 *
 * N.B. PLEASE DO NOT MODIFY THIS FILE.
 */

package ru.ispras.microtesk.model.x86.op;

import java.util.Map;
import java.math.BigInteger;
import ru.ispras.microtesk.model.Execution;
import ru.ispras.microtesk.model.ProcessingElement;
import ru.ispras.microtesk.model.data.*;
import ru.ispras.microtesk.model.memory.*;
import ru.ispras.microtesk.model.*;
import ru.ispras.microtesk.model.x86.PE;
import ru.ispras.microtesk.model.x86.TempVars;
import ru.ispras.microtesk.model.memory.Location;

import static ru.ispras.microtesk.model.x86.TypeDefs.*;

public final class xor_proc_byte extends IsaPrimitive {
  private static final class Info extends IsaPrimitiveInfoAnd {
    Info() {
      super(
          IsaPrimitiveKind.OP,
          "xor_proc_byte",
          xor_proc_byte.class,
          null
          );
      addArgument("op1", BYTE);
      addArgument("op2", BYTE);}

    @Override
    public IsaPrimitive create(final Map<String, IsaPrimitive> args) {
      final Immediate op1 = (Immediate) getArgument("op1", args);
      final Immediate op2 = (Immediate) getArgument("op2", args);

      return new xor_proc_byte(op1, op2);
    }
  }
  public static final IsaPrimitiveInfoAnd INFO = new Info();

  public final Immediate op1;
  public final Immediate op2;

  public xor_proc_byte(final Immediate op1, final Immediate op2) {
    assert BYTE.equals(op1.getType());
    assert BYTE.equals(op2.getType());

    this.op1 = op1;
    this.op2 = op2;

    addArgument("op1", op1);
    addArgument("op2", op2);
  }

  @Override
  public void action(final ProcessingElement procElem, final TemporaryVariables tempVars) {
    final PE pe__ = (PE) procElem;
    final TempVars vars__ = (TempVars) tempVars;
    vars__.tmpb_res.access().store(Data.zeroExtend(Type.CARD(9), op1.access().load().xor(op2.access().load())));
    pe__.CF.access().store(Data.valueOf(BIT, 0x0));
    pe__.OF.access().store(Data.valueOf(BIT, 0x0));
    pe__.SF.access().store(vars__.tmpb_res.access().bitField(7, 7).load());
    pe__.ZF.access().store(Data.valueOf(BIT, vars__.tmpb_res.access().bitField(7, 0).load().equals(Data.valueOf(Type.CARD(8), 0x0))));
  }
}