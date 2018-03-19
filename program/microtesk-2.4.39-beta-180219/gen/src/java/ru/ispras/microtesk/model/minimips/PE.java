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

package ru.ispras.microtesk.model.minimips;

import java.math.BigInteger;
import ru.ispras.microtesk.model.ProcessingElement;
import ru.ispras.microtesk.model.data.Type;
import ru.ispras.microtesk.model.memory.Label;
import ru.ispras.microtesk.model.memory.Memory;

/**
 * The {@code PE} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class PE extends ProcessingElement {
  public final Memory GPR;
  public final Memory COP0_R;
  public final Memory HI;
  public final Memory LO;
  public final Memory CIA;
  public final Memory CIA_COPY;
  public final Memory PID;
  public final Memory M;
  public final Memory BRANCH;
  public final Memory JMPADDR;
  public final Memory MMU_PA;

  private PE() {
    super();
    this.GPR = Memory.def(Memory.Kind.REG, "GPR", TypeDefs.WORD, 32);
    this.COP0_R = Memory.def(Memory.Kind.REG, "COP0_R", TypeDefs.WORD, 32);
    this.HI = Memory.def(Memory.Kind.REG, "HI", TypeDefs.WORD, 1);
    this.LO = Memory.def(Memory.Kind.REG, "LO", TypeDefs.WORD, 1);
    this.CIA = Memory.def(Memory.Kind.REG, "CIA", TypeDefs.WORD, 1);
    this.CIA_COPY = Memory.def(Memory.Kind.REG, "CIA_COPY", TypeDefs.WORD, 1);
    this.PID = Memory.def(Memory.Kind.REG, "PID", TypeDefs.WORD, 1);
    this.M = Memory.def(Memory.Kind.MEM, "M", TypeDefs.WORD, 0x40000000);
    this.BRANCH = Memory.def(Memory.Kind.REG, "BRANCH", TypeDefs.BIT, 1);
    this.JMPADDR = Memory.def(Memory.Kind.REG, "JMPADDR", TypeDefs.WORD, 1);
    this.MMU_PA = Memory.def(Memory.Kind.REG, "MMU_PA", TypeDefs.WORD, 1);

    registerAll();
  }

  private PE(final PE other, final boolean shared) {
    super(other);
    this.GPR = other.GPR.copy();
    this.COP0_R = other.COP0_R.copy();
    this.HI = other.HI.copy();
    this.LO = other.LO.copy();
    this.CIA = other.CIA.copy();
    this.CIA_COPY = other.CIA_COPY.copy();
    this.PID = other.PID.copy();
    this.M = shared ? other.M : other.M.copy();
    this.BRANCH = other.BRANCH.copy();
    this.JMPADDR = other.JMPADDR.copy();
    this.MMU_PA = other.MMU_PA.copy();

    registerAll();
  }

  private void registerAll() {
    addStorage(GPR);
    addStorage(COP0_R);
    addStorage(HI);
    addStorage(LO);
    addStorage(CIA);
    addStorage(CIA_COPY);
    addStorage(PID);
    addStorage(M);
    addStorage(BRANCH);
    addStorage(JMPADDR);
    addStorage(MMU_PA);

    addLabel(new Label("PC", CIA, 0));
  }

  @Override
  public ProcessingElement copy(final boolean shared) {
    return new PE(this, shared);
  }

  private static final class PEFactory implements Factory {
    @Override
    public PE create() {
      return new PE();
    }
  }

  public static Factory newFactory() {
    return new PEFactory();
  }
}
