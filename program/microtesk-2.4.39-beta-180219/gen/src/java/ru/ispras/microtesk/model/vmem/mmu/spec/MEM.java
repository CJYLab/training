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
 * The {@code MEM} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class MEM extends MmuBuffer {
  private static MEM INSTANCE = null;

  public static MEM get() {
    if (null == INSTANCE) {
      INSTANCE = new MEM();
    }
    return INSTANCE;
  }

  private final PA pa = PA.get();

  public static final class Entry extends MmuStruct {
    public final NodeVariable data;

    public Entry(final String name) {
      super(name);

      this.data = new NodeVariable(name + ".data", DataType.bitVector(16));

      addField(data);
    }
  }

  public final NodeVariable data;

  private MEM() {
    this("MEM");
  }

  private MEM(final String name) {
    super(
        name,
        Kind.UNMAPPED,
        1L,
        8192L,
        PA.get(),
        Nodes.FALSE,
        Nodes.bvextract(13, 1, PA.get().value),
        Nodes.bvextract(0, 0, PA.get().value),
        Collections.<MmuBinding>emptyList(), // set up with setMatchBindings
        false,
        null
    );

    this.data = new NodeVariable(name + ".data", DataType.bitVector(16));

    addField(data);
  }
}
