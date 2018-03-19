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

package ru.ispras.microtesk.model.x86.metadata;

import static ru.ispras.microtesk.model.x86.TypeDefs.*;

import ru.ispras.microtesk.model.ArgumentMode;
import ru.ispras.microtesk.model.metadata.MetaArgument;
import ru.ispras.microtesk.model.metadata.MetaOperation;
import ru.ispras.microtesk.model.data.Type;

/**
 * The {@code jnl} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class jnl extends MetaOperation {
  private static jnl instance = null;

  public static jnl get() {
    if (null == instance) {
      instance = new jnl();
    }
    return instance;
  }

  private jnl() {
    super(
        "jnl",
        "jnl",
        false,
        false,
        false,
        false,
        false,
        false,
        0
        );
    addArgument(new MetaArgument("rel", SBYTE));

    addShortcut("#root", instruction_jnl.get());
  }

  private static final class instruction_jnl extends MetaOperation {
    private static instruction_jnl instance = null;

    public static instruction_jnl get() {
      if (null == instance) {
        instance = new instruction_jnl();
      }
      return instance;
    }

    private instruction_jnl() {
      super(
          "jnl",
          "instruction",
          true,
          true,
          true,
          false,
          false,
          false,
          0
          );
      addArgument(new MetaArgument("rel", SBYTE));
    }
  }
}
