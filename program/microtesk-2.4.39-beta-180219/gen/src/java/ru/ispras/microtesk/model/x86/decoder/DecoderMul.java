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
 * The {@code DecoderMul} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class DecoderMul extends DecoderGroup {
  private static DecoderMul instance = null;

  public static DecoderMul get() {
    if (null == instance) {
      instance = new DecoderMul();
    }
    return instance;
  }

  private DecoderMul() {
    super(41, false, null);

    add(DecoderMul_r8.get());
    add(DecoderMul_m8.get());
    add(DecoderMul_r16.get());
    add(DecoderMul_m16.get());
  }
}
