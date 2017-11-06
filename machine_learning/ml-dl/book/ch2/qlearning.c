/********************************************/
/*         qlearning.c                      */
/*   �����w�K(Q�w�K)�̗��v���O����        */
/*�@ ���H�̒T�����w�K���܂�                 */
/*�g����                                    */
/*:\Users\odaka\dl\ch2>qlearning            */
/********************************************/

/*Visual Studio�Ƃ̌݊����m�� */
#define _CRT_SECURE_NO_WARNINGS

/*�w�b�_�t�@�C���̃C���N���[�h*/
#include <stdio.h>
#include <stdlib.h>

/* �L���萔�̒�`             */
#define GENMAX  1000 /*�w�K�̌J��Ԃ���*/
#define NODENO  15  /*�p�l�̃m�[�h��*/
#define ALPHA 0.1/*�w�K�W��*/
#define GAMMA 0.9/*������*/
#define EPSILON 0.3 /*�s���I���̃����_����������*/
#define SEED 32767 /*�����̃V�[�h*/

/* �֐��̃v���g�^�C�v�̐錾   */
int rand100() ;/*0�`100��Ԃ������֐�*/
int rand01() ;/*0����1��Ԃ������֐�*/
double rand1() ;/*0�`1�̎�����Ԃ������֐�*/
void printqvalue(int qvalue[NODENO]);/*Q�l�o��*/
int selecta(int s,int qvalue[NODENO]);/*�s���I��*/
int updateq(int s,int qvalue[NODENO]);/*Q�l�X�V*/

/****************/
/*  main()�֐�  */
/****************/
int main()
{
 int i;
 int s;/*���*/
 int t;/*����*/
 int qvalue[NODENO];/*Q�l*/


 srand(SEED);/*�����̏�����*/

 /*�p�l�̏�����*/
 for(i=0;i<NODENO;++i)
  qvalue[i]=rand100() ;
 printqvalue(qvalue) ;


 /*�w�K�̖{��*/
 for(i=0;i<GENMAX;++i){
  s=0;/*�s���̏������*/
  for(t=0;t<3;++t){/*�ŉ��i�܂ŌJ��Ԃ�*/
   /*�s���I��*/
   s=selecta(s,qvalue) ;
   
   /*Q�l�̍X�V*/
   qvalue[s]=updateq(s,qvalue) ;
  }
  /*Q�l�̏o��*/
  printqvalue(qvalue) ;
 }
 return 0;
}

/****************************/
/*       updateq()�֐�      */
/*�@     Q�l���X�V����      */
/****************************/
int updateq(int s,int qvalue[NODENO])
{
 int qv ;/*�X�V�����Q�l*/
 int qmax ;/*�p�l�̍ő�l*/
 
 /*�ŉ��i�̏ꍇ*/
 if(s>6){
  if(s==14)/*��V�̕t�^*/
   qv=qvalue[s]+ALPHA*(1000-qvalue[s]) ;
  /*��V��^����m�[�h�𑝂₷*/
  /*���̃m�[�h��ǉ�����ꍇ��*/
  /*���L2�s�̃R�����g���O��   */
//  else if(s==11)/*��V�̕t�^*/
//   qv=qvalue[s]+ALPHA*(500-qvalue[s]) ;
  else/*��V�Ȃ�*/
   qv=qvalue[s] ;
 }
 /*�ŉ��i�ȊO*/
 else{
  if((qvalue[2*s+1])>(qvalue[2*s+2])) 
   qmax=qvalue[2*s+1];
  else qmax=qvalue[2*s+2];
  qv=qvalue[s]+ALPHA*(GAMMA*qmax-qvalue[s]) ;
 }

 return qv ;
}

/****************************/
/*        selecta()�֐�     */
/*�@     �s����I������     */
/****************************/
int selecta(int olds,int qvalue[NODENO])
{
 int s ;
 
 /*��-greedy�@�ɂ��s���I��*/
 if(rand1()<EPSILON){
  /*�����_���ɍs��*/
  if(rand01()==0) s=2*olds+1 ;
  else s=2*olds+2 ;
 }
 else{
  /*�p�l�ő�l��I��*/
  if((qvalue[2*olds+1])>(qvalue[2*olds+2])) 
   s=2*olds+1;
  else s=2*olds+2;
 }

 return s ;
}



/****************************/
/*    printqvalue()�֐�     */
/*�@   Q�l���o�͂���        */
/****************************/
void printqvalue(int qvalue[NODENO])
{
 int i ;
 
 for (i=1;i<NODENO;++i)
  printf("%d\t",qvalue[i]);

 printf("\n");

}

/****************************/
/*     rand1()�֐�          */
/*0�`1�̎�����Ԃ������֐�  */
/****************************/
double rand1()
{
 /*�����̌v�Z*/ 
 return (double)rand()/RAND_MAX ;

}

/****************************/
/*     rand01()�֐�         */
/*�@   0����1��Ԃ������֐� */
/****************************/
int rand01()
{
 int rnd ;
 
 /*�����̍ő�l������*/
 while((rnd=rand())==RAND_MAX) ;
 /*�����̌v�Z*/ 
 return (int)((double)rnd/RAND_MAX*2) ;

}

/****************************/
/*     rand100()�֐�        */
/*�@   0�`100��Ԃ������֐� */
/****************************/
int rand100()
{
 int rnd ;
 
 /*�����̍ő�l������*/
 while((rnd=rand())==RAND_MAX) ;
 /*�����̌v�Z*/ 
 return (int)((double)rnd/RAND_MAX*101) ;

}

