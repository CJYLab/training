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

package ru.ispras.microtesk.model.vmem.mmu.spec;

import ru.ispras.fortress.data.types.bitvector.BitVector;
import ru.ispras.fortress.data.Data;
import ru.ispras.fortress.data.DataType;
import ru.ispras.fortress.expression.Nodes;
import ru.ispras.fortress.expression.NodeValue;
import ru.ispras.fortress.expression.NodeVariable;
import ru.ispras.microtesk.mmu.translator.ir.spec.MmuSegment;
import ru.ispras.microtesk.mmu.translator.ir.spec.MmuSubsystem;
import java.util.Arrays;
import java.math.BigInteger;
import ru.ispras.microtesk.mmu.basis.BufferAccessEvent;
import ru.ispras.microtesk.mmu.translator.ir.spec.MmuAction;
import ru.ispras.microtesk.mmu.translator.ir.spec.MmuBinding;
import ru.ispras.microtesk.mmu.translator.ir.spec.MmuBufferAccess;
import ru.ispras.microtesk.mmu.translator.ir.spec.MmuGuard;
import ru.ispras.microtesk.mmu.translator.ir.spec.MmuSegment;
import ru.ispras.microtesk.mmu.translator.ir.spec.MmuTransition;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code DIRECT} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class DIRECT extends MmuSegment {
  private static DIRECT INSTANCE = null;

  public static DIRECT get() {
    if (null == INSTANCE) {
      INSTANCE = new DIRECT();
    }
    return INSTANCE;
  }

  private DIRECT() {
    this("DIRECT");
  }

  private DIRECT(final String name) {
    super(
        "DIRECT",
        VA.get(),
        PA.get(),
        BitVector.valueOf(0xC000, 16),
        BitVector.valueOf(0xFFFF, 16)
        );
  }

  private int callIndex = 0;

  public final Function newCall(final MmuSubsystem.Builder builder, final VA va, final PA pa) {
    return new Function(builder, callIndex++, va, pa);
  }

  public static final class Function {
    public final VA va;
    public final PA pa;

    public final MmuAction START;
    public final MmuAction STOP;

    private final MmuAction ASSIGN_0;

    private Function(final MmuSubsystem.Builder builder, final int instanceIndex, final VA va, final PA pa) {
      this(builder, String.format("DIRECT_%d", instanceIndex), va, pa);
    }

    private Function(final MmuSubsystem.Builder builder, final String name, final VA va, final PA pa) {
      this.va = va;
      this.pa = pa;

      this.START = new MmuAction(name + ".START");
      builder.registerAction(START);
      this.STOP = new MmuAction(name + ".STOP");
      builder.registerAction(STOP);

      this.ASSIGN_0 = new MmuAction(name + ".ASSIGN_0", new MmuBinding(pa.value, Nodes.bvextract(13, 0, va.value)));
      builder.registerAction(ASSIGN_0);
      builder.registerTransition(new MmuTransition(START, ASSIGN_0));
      builder.registerTransition(new MmuTransition(ASSIGN_0, STOP));
    }
  }
}
