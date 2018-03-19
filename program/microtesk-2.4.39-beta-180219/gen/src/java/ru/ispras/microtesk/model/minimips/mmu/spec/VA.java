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

import ru.ispras.fortress.data.DataType;
import ru.ispras.fortress.expression.NodeVariable;
import ru.ispras.microtesk.mmu.translator.ir.spec.MmuAddressInstance;

/**
 * The {@code VA} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class VA extends MmuAddressInstance {
  private static VA INSTANCE = null;

  public static VA get() {
    if (null == INSTANCE) {
      INSTANCE = new VA();
    }
    return INSTANCE;
  }

  public final NodeVariable value;

  private VA() {
    this("VA");
  }

  public VA(final String name) {
    super(name);

    this.value = new NodeVariable(name + ".value", DataType.bitVector(32));

    addField(value);

    setVariable(value);
  }
}
