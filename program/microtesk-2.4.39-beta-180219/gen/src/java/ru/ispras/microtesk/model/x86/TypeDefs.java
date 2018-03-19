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

package ru.ispras.microtesk.model.x86;

import ru.ispras.microtesk.model.data.Type;

/**
 * The {@code TypeDefs} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class TypeDefs {
  private TypeDefs() {}

  public static final Type BIT = Type.def("BIT", Type.CARD(1));
  public static final Type BYTE = Type.def("BYTE", Type.CARD(8));
  public static final Type SBYTE = Type.def("SBYTE", Type.INT(8));
  public static final Type SIZE = Type.def("SIZE", Type.CARD(4));
  public static final Type addR = Type.def("addR", Type.CARD(20));
  public static final Type WORD = Type.def("WORD", Type.CARD(16));
  public static final Type SWORD = Type.def("SWORD", Type.INT(16));
  public static final Type DWORD = Type.def("DWORD", Type.CARD(32));
  public static final Type INDEX = Type.def("INDEX", Type.CARD(3));
}
