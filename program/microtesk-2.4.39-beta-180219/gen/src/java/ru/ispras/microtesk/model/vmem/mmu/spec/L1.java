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

import java.util.Collections;
import java.util.Arrays;
import java.math.BigInteger;
import ru.ispras.fortress.data.DataType;
import ru.ispras.fortress.expression.NodeVariable;
import ru.ispras.fortress.data.types.bitvector.BitVector;
import ru.ispras.fortress.expression.Nodes;
import ru.ispras.fortress.expression.NodeValue;
import ru.ispras.microtesk.mmu.translator.ir.spec.MmuBinding;
import ru.ispras.microtesk.mmu.translator.ir.spec.MmuBuffer;
import ru.ispras.microtesk.mmu.translator.ir.spec.MmuStruct;

/**
 * The {@code L1} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class L1 extends MmuBuffer {
  private static L1 INSTANCE = null;

  public static L1 get() {
    if (null == INSTANCE) {
      INSTANCE = new L1();
    }
    return INSTANCE;
  }

  private final PA pa = PA.get();

  public static final class Entry extends MmuStruct {
    public final NodeVariable tag;
    public final NodeVariable data;

    public Entry(final String name) {
      super(name);

      this.tag = new NodeVariable(name + ".tag", DataType.bitVector(12));
      this.data = new NodeVariable(name + ".data", DataType.bitVector(16));

      addField(tag);
      addField(data);
    }
  }

  public final NodeVariable tag;
  public final NodeVariable data;

  private L1() {
    this("L1");
  }

  private L1(final String name) {
    super(
        name,
        Kind.UNMAPPED,
        4L,
        2L,
        PA.get(),
        Nodes.bvextract(13, 2, PA.get().value),
        Nodes.bvextract(1, 1, PA.get().value),
        Nodes.bvextract(0, 0, PA.get().value),
        Collections.<MmuBinding>emptyList(), // set up with setMatchBindings
        true,
        null
    );

    this.tag = new NodeVariable(name + ".tag", DataType.bitVector(12));
    this.data = new NodeVariable(name + ".data", DataType.bitVector(16));

    addField(tag);
    addField(data);

    setMatchBindings(Arrays.<MmuBinding>asList(
        new MmuBinding(tag, Nodes.bvextract(13, 2, PA.get().value))));
  }
}
