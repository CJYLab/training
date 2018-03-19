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

import ru.ispras.microtesk.model.metadata.MetaGroup;

/**
 * The {@code push} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class push extends MetaGroup {
  private static push instance = null;

  public static push get() {
    if (null == instance) {
      instance = new push();
    }
    return instance;
  }

  private push() {
    super(
        MetaGroup.Kind.OP,
        "push",
        push_rseg.get(),
        push_r16.get(),
        push_m16.get()
        );
  }
}
