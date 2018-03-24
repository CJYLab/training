#ifndef __FIFO_H__
#define __FIFO_H__

/* fifo.c */
#define FLAGS_OVERRUN 0x0001;

struct FIFO8 {
  unsigned char *buf;
  int p, q, size, free, flags;
};

void fifo8_init (struct FIFO8 *fifo, int size, unsigned char *buf);
int fifo8_put (struct FIFO8 *fifo, unsigned char data);
int fifo8_get (struct FIFO8 *fifo);
int fifo8_status (struct FIFO8 *fifo);

#endif // __FIFO_H__
