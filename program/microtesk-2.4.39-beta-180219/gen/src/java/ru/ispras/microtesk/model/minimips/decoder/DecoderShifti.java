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

package ru.ispras.microtesk.model.minimips.decoder;

import ru.ispras.microtesk.model.decoder.DecoderGroup;

/**
 * The {@code DecoderShifti} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class DecoderShifti extends DecoderGroup {
  private static DecoderShifti instance = null;

  public static DecoderShifti get() {
    if (null == instance) {
      instance = new DecoderShifti();
    }
    return instance;
  }

  private DecoderShifti() {
    super(32, true, "11111111111000000000000000111111");

    add(DecoderSll.get());
    add(DecoderSra.get());
    add(DecoderSrl.get());
  }
}
