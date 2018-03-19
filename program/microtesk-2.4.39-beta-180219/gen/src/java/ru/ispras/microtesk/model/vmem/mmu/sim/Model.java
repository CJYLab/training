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

package ru.ispras.microtesk.model.vmem.mmu.sim;

import ru.ispras.microtesk.mmu.model.api.MmuModel;

/**
 * The {@code Model} class is automatically generated by MicroTESK.
 *
 * @author <a href="mailto:microtesk-support@ispras.ru">MicroTESK</a>
 */
public final class Model extends MmuModel {
  public Model() {
    super(vmem.get(), "MEM", MEM.get());

    addBuffer("PageTable", PageTable.get());
    addBuffer("TLB", TLB.get());
    addBuffer("MEM", MEM.get());
    addBuffer("L1", L1.get());
    addBuffer("DIRECT", DIRECT.get());
    addBuffer("MAPPED", MAPPED.get());
  }
}
