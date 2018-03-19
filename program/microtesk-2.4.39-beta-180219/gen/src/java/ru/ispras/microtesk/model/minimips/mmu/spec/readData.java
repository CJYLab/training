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

package ru.ispras.microtesk.model.minimips.mmu.spec;

import java.util.ArrayList;
import java.util.List;
import ru.ispras.fortress.data.types.bitvector.BitVector;
import ru.ispras.fortress.data.Data;
import ru.ispras.fortress.data.DataType;
import ru.ispras.fortress.data.Variable;
import ru.ispras.fortress.expression.NodeVariable;
import ru.ispras.fortress.expression.Nodes;
import ru.ispras.fortress.expression.NodeValue;
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

/**
 * The {@code readData} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class readData {
  private static readData INSTANCE = null;

  public static readData get() {
    if (null == INSTANCE) {
      INSTANCE = new readData();
    }
    return INSTANCE;
  }

  private int callIndex = 0;

  public final Function newCall(
      final MmuSubsystem.Builder builder,
      final NodeVariable readData,
      final NodeVariable block,
      final NodeVariable offset) {
    return new Function(builder, callIndex++, readData, block, offset);
  }

  public static final class Function {
    public final NodeVariable readData;
    public final NodeVariable block;
    public final NodeVariable offset;



    public final MmuAction START;
    public final MmuAction STOP;

    private final MmuAction BRANCH_0;
    private final MmuAction ASSIGN_0;
    private final MmuAction BRANCH_1;
    private final MmuAction ASSIGN_1;
    private final MmuAction BRANCH_2;
    private final MmuAction ASSIGN_2;
    private final MmuAction BRANCH_3;
    private final MmuAction ASSIGN_3;
    private final MmuAction BRANCH_4;
    private final MmuAction ASSIGN_4;
    private final MmuAction BRANCH_5;
    private final MmuAction ASSIGN_5;
    private final MmuAction BRANCH_6;
    private final MmuAction ASSIGN_6;
    private final MmuAction BRANCH_7;
    private final MmuAction ASSIGN_7;

    private Function(
        final MmuSubsystem.Builder builder,
        final int instanceIndex,
        final NodeVariable readData,
        final NodeVariable block,
        final NodeVariable offset) {
      final String name = String.format("readData_%d", instanceIndex);
      this.readData = readData; 
      this.block = block; 
      this.offset = offset; 

      this.START = new MmuAction(name + ".START");
      builder.registerAction(START);
      this.STOP = new MmuAction(name + ".STOP");
      builder.registerAction(STOP);

      this.BRANCH_0 = new MmuAction(name + ".BRANCH_0");
      builder.registerAction(BRANCH_0);
      builder.registerTransition(new MmuTransition(START, BRANCH_0, new MmuGuard(Nodes.eq(offset, NodeValue.newBitVector(0x0, 3)))));
      this.ASSIGN_0 = new MmuAction(name + ".ASSIGN_0", new MmuBinding(readData, Nodes.bvextract(31, 0, block)));
      builder.registerAction(ASSIGN_0);
      builder.registerTransition(new MmuTransition(BRANCH_0, ASSIGN_0));
      builder.registerTransition(new MmuTransition(ASSIGN_0, STOP));
      this.BRANCH_1 = new MmuAction(name + ".BRANCH_1");
      builder.registerAction(BRANCH_1);
      builder.registerTransition(new MmuTransition(START, BRANCH_1, new MmuGuard(Nodes.eq(offset, NodeValue.newBitVector(0x1, 3)))));
      this.ASSIGN_1 = new MmuAction(name + ".ASSIGN_1", new MmuBinding(readData, Nodes.bvextract(63, 32, block)));
      builder.registerAction(ASSIGN_1);
      builder.registerTransition(new MmuTransition(BRANCH_1, ASSIGN_1));
      builder.registerTransition(new MmuTransition(ASSIGN_1, STOP));
      this.BRANCH_2 = new MmuAction(name + ".BRANCH_2");
      builder.registerAction(BRANCH_2);
      builder.registerTransition(new MmuTransition(START, BRANCH_2, new MmuGuard(Nodes.eq(offset, NodeValue.newBitVector(0x2, 3)))));
      this.ASSIGN_2 = new MmuAction(name + ".ASSIGN_2", new MmuBinding(readData, Nodes.bvextract(95, 64, block)));
      builder.registerAction(ASSIGN_2);
      builder.registerTransition(new MmuTransition(BRANCH_2, ASSIGN_2));
      builder.registerTransition(new MmuTransition(ASSIGN_2, STOP));
      this.BRANCH_3 = new MmuAction(name + ".BRANCH_3");
      builder.registerAction(BRANCH_3);
      builder.registerTransition(new MmuTransition(START, BRANCH_3, new MmuGuard(Nodes.eq(offset, NodeValue.newBitVector(0x3, 3)))));
      this.ASSIGN_3 = new MmuAction(name + ".ASSIGN_3", new MmuBinding(readData, Nodes.bvextract(127, 96, block)));
      builder.registerAction(ASSIGN_3);
      builder.registerTransition(new MmuTransition(BRANCH_3, ASSIGN_3));
      builder.registerTransition(new MmuTransition(ASSIGN_3, STOP));
      this.BRANCH_4 = new MmuAction(name + ".BRANCH_4");
      builder.registerAction(BRANCH_4);
      builder.registerTransition(new MmuTransition(START, BRANCH_4, new MmuGuard(Nodes.eq(offset, NodeValue.newBitVector(0x4, 3)))));
      this.ASSIGN_4 = new MmuAction(name + ".ASSIGN_4", new MmuBinding(readData, Nodes.bvextract(159, 128, block)));
      builder.registerAction(ASSIGN_4);
      builder.registerTransition(new MmuTransition(BRANCH_4, ASSIGN_4));
      builder.registerTransition(new MmuTransition(ASSIGN_4, STOP));
      this.BRANCH_5 = new MmuAction(name + ".BRANCH_5");
      builder.registerAction(BRANCH_5);
      builder.registerTransition(new MmuTransition(START, BRANCH_5, new MmuGuard(Nodes.eq(offset, NodeValue.newBitVector(0x5, 3)))));
      this.ASSIGN_5 = new MmuAction(name + ".ASSIGN_5", new MmuBinding(readData, Nodes.bvextract(191, 160, block)));
      builder.registerAction(ASSIGN_5);
      builder.registerTransition(new MmuTransition(BRANCH_5, ASSIGN_5));
      builder.registerTransition(new MmuTransition(ASSIGN_5, STOP));
      this.BRANCH_6 = new MmuAction(name + ".BRANCH_6");
      builder.registerAction(BRANCH_6);
      builder.registerTransition(new MmuTransition(START, BRANCH_6, new MmuGuard(Nodes.eq(offset, NodeValue.newBitVector(0x6, 3)))));
      this.ASSIGN_6 = new MmuAction(name + ".ASSIGN_6", new MmuBinding(readData, Nodes.bvextract(223, 192, block)));
      builder.registerAction(ASSIGN_6);
      builder.registerTransition(new MmuTransition(BRANCH_6, ASSIGN_6));
      builder.registerTransition(new MmuTransition(ASSIGN_6, STOP));
      this.BRANCH_7 = new MmuAction(name + ".BRANCH_7");
      builder.registerAction(BRANCH_7);
      builder.registerTransition(new MmuTransition(START, BRANCH_7, new MmuGuard(Nodes.and(Nodes.noteq(offset, NodeValue.newBitVector(0x0, 3)), Nodes.noteq(offset, NodeValue.newBitVector(0x1, 3)), Nodes.noteq(offset, NodeValue.newBitVector(0x2, 3)), Nodes.noteq(offset, NodeValue.newBitVector(0x3, 3)), Nodes.noteq(offset, NodeValue.newBitVector(0x4, 3)), Nodes.noteq(offset, NodeValue.newBitVector(0x5, 3)), Nodes.noteq(offset, NodeValue.newBitVector(0x6, 3))))));
      this.ASSIGN_7 = new MmuAction(name + ".ASSIGN_7", new MmuBinding(readData, Nodes.bvextract(255, 224, block)));
      builder.registerAction(ASSIGN_7);
      builder.registerTransition(new MmuTransition(BRANCH_7, ASSIGN_7));
      builder.registerTransition(new MmuTransition(ASSIGN_7, STOP));
    }
  }
}
