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

package ru.ispras.microtesk.model.x86.decoder;

import ru.ispras.microtesk.model.decoder.DecoderGroup;

/**
 * The {@code DecoderLea} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class DecoderLea extends DecoderGroup {
  private static DecoderLea instance = null;

  public static DecoderLea get() {
    if (null == instance) {
      instance = new DecoderLea();
    }
    return instance;
  }

  private DecoderLea() {
    super(24, true, "111110000000000000000000");

    add(DecoderLea_r16label.get());
  }
}
