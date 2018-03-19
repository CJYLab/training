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

package ru.ispras.microtesk.model.vliw.metadata;

import ru.ispras.microtesk.model.metadata.MetaGroup;

/**
 * The {@code ALU} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class ALU extends MetaGroup {
  private static ALU instance = null;

  public static ALU get() {
    if (null == instance) {
      instance = new ALU();
    }
    return instance;
  }

  private ALU() {
    super(
        MetaGroup.Kind.OP,
        "ALU",
        ADD.get(),
        ADDI.get(),
        SUB.get(),
        MUL.get(),
        SLL.get(),
        SRL.get(),
        MOVN.get(),
        MOVZ.get(),
        MOVE.get(),
        AND.get(),
        OR.get(),
        XOR.get(),
        SLT.get(),
        SLTI.get()
        );
  }
}
