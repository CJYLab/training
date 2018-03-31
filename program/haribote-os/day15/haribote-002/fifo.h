#ifndef __FIFO_H__
#define __FIFO_H__

/* fifo.c */
#define FLAGS_OVERRUN 0x0001;

struct FIFO32 {
  int *buf;
  int p, q, size, free, flags;
};

void fifo32_init (struct FIFO32 *fifo, int size, int *buf);
int fifo32_put (struct FIFO32 *fifo, int data);
int fifo32_get (struct FIFO32 *fifo);
int fifo32_status (struct FIFO32 *fifo);

#endif // __FIFO_H__
