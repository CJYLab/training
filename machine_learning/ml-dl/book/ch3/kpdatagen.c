/****************************************/
/*              kpdatagen.c             */
/*  �i�b�v�T�b�N���̃f�[�^�����@      */
/* �ו��̏d���Ɖ��l�𗐐��Ő������܂�   */
/*�g����                                */
/*\Users\odaka\dl\ch3>kpdatagen>data.txt*/
/****************************************/


/*Visual Studio�Ƃ̌݊����m�� */
#define _CRT_SECURE_NO_WARNINGS

/*�w�b�_�t�@�C���̃C���N���[�h*/
#include <stdio.h>
#include <stdlib.h>

/*   �L���萔�̒�`                 */
#define MAXVALUE 100 /*�d���Ɖ��l�̍ő�l*/
#define N 30 /*�ו��̌�*/
#define SEED 32768 /*�����̃V�[�h*/

/*   �֐��̃v���g�^�C�v�̐錾      */
int randdata() ;
    /*MAXVALUE�ȉ��̐�����Ԃ������֐�*/

/****************/
/*  main()�֐�  */
/****************/
int main()
{
 int i ;

 srand(SEED) ;
 for(i=0;i<N;++i)
  printf("%ld %ld\n",randdata(),randdata()) ;
 return 0 ;
}

/**********************************/
/*     randdata()�֐�             */
/*MAXVALUE�ȉ��̐�����Ԃ������֐�*/
/**********************************/
int randdata()
{
 int rnd ;
 
 /*�����̍ő�l������*/
 while((rnd=rand())==RAND_MAX) ;
 /*�����̌v�Z*/ 
 return (int)((double)rnd/RAND_MAX*MAXVALUE+1) ;

}
