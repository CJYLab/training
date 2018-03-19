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

package ru.ispras.microtesk.model.x86.mode;

import java.util.Map;
import java.math.BigInteger;
import ru.ispras.microtesk.model.Execution;
import ru.ispras.microtesk.model.ProcessingElement;
import ru.ispras.microtesk.model.data.*;
import ru.ispras.microtesk.model.*;
import ru.ispras.microtesk.model.memory.Location;
import ru.ispras.microtesk.model.x86.PE;
import ru.ispras.microtesk.model.x86.TempVars;

import static ru.ispras.microtesk.model.x86.TypeDefs.*;

public final class BIDAM_BX_SI_D16 extends IsaPrimitive {
  public static final String NAME = "BIDAM_BX_SI_D16";

  private static final class Info extends IsaPrimitiveInfoAnd {
    Info() {
      super(
          IsaPrimitiveKind.MODE,
          "BIDAM_BX_SI_D16",
          BIDAM_BX_SI_D16.class,
          addR
          );
      addArgument("disp", WORD);
    }

    @Override
    public IsaPrimitive create(final Map<String, IsaPrimitive> args) {
      final Immediate disp = (Immediate) getArgument("disp", args);
      return new BIDAM_BX_SI_D16(disp);
    }
  }

  public static final IsaPrimitiveInfoAnd INFO = new Info();

  public final Immediate disp;

  public BIDAM_BX_SI_D16(final Immediate disp) {
    this.disp = disp;

    addArgument("disp", disp);
  }

  @Override
  public String syntax(final TemporaryVariables tempVars) {
    final TempVars vars__ = (TempVars) tempVars;
    init(vars__);
    return String.format("%d[BX+SI]", disp.access().load().bigIntegerValue());
  }

  @Override
  public String image(final TemporaryVariables tempVars) {
    final TempVars vars__ = (TempVars) tempVars;
    init(vars__);
    return String.format("%s", Location.concat(disp.access().bitField(7, 0), disp.access().bitField(15, 8)).toString());
  }

  @Override
  public void init(final TemporaryVariables tempVars) {
    final TempVars vars__ = (TempVars) tempVars;
    vars__.mod.access().store(Data.valueOf(Type.CARD(2), 0x3));
    vars__.rm.access().store(Data.valueOf(Type.CARD(3), 0x0));
  }

  @Override
  public void action(final ProcessingElement procElem, final TemporaryVariables tempVars) {
    final PE pe__ = (PE) procElem;
    final TempVars vars__ = (TempVars) tempVars;
    init(vars__);
    vars__.instruction_image_size.access().store(Data.valueOf(SIZE, 0x2));
  }

  @Override
  public Location access(final ProcessingElement procElem, final TemporaryVariables tempVars) {
    final PE pe__ = (PE) procElem;
    final TempVars vars__ = (TempVars) tempVars;
    return annotate(new Location(Data.signExtend(addR, Data.cast(SWORD, pe__.BX.access().load().add(pe__.SI.access().load()).add(disp.access().load())))), vars__);
  }
}