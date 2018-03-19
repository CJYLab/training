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
 * The {@code DecoderSbb} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class DecoderSbb extends DecoderGroup {
  private static DecoderSbb instance = null;

  public static DecoderSbb get() {
    if (null == instance) {
      instance = new DecoderSbb();
    }
    return instance;
  }

  private DecoderSbb() {
    super(57, false, null);

    add(DecoderSbb_m8r8.get());
    add(DecoderSbb_r8r8.get());
    add(DecoderSbb_r8m8.get());
    add(DecoderSbb_r8i8.get());
    add(DecoderSbb_m8i8.get());
    add(DecoderSbb_r16r16.get());
    add(DecoderSbb_r16m16.get());
    add(DecoderSbb_r16i16.get());
    add(DecoderSbb_m16i16.get());
    add(DecoderSbb_m16r16.get());
  }
}
