/*************************************/
/*              direct.c             */
/*�S�T���Ńi�b�v�T�b�N��������     */
/*�g����                             */
/*\Users\odaka\dl\ch3>direct<data.txt*/
/*************************************/


/*Visual Studio�Ƃ̌݊����m�� */
#define _CRT_SECURE_NO_WARNINGS

/*�w�b�_�t�@�C���̃C���N���[�h*/
#include <stdio.h>
#include <stdlib.h>


/*   �L���萔�̒�`                 */
#define MAXVALUE 100 /*�d���Ɖ��l�̍ő�l*/
#define N 30 /*�ו��̌�*/
#define WEIGHTLIMIT (N*MAXVALUE/10)
             /*�d�ʐ���*/
#define SEED 32768 /*�����̃V�[�h*/

/*   �֐��̃v���g�^�C�v�̐錾      */
void initparcel(int parcel [N][2]);/*�ו��̏�����*/
void prints(int solution);/*�����̏o��*/
int solve(int parcel [N][2]) ;/*�T���̖{��*/
int pow2n(int n);/*2�ׂ̂���*/
int calcval(int parcel[N][2],int i);/*�]���l�̌v�Z*/

/****************/
/*  main()�֐�  */
/****************/
int main()
{
 int parcel[N][2] ;/*�ו�*/
 int solution=0xfff ;/*��*/

 /*�ו��̏�����*/
 initparcel(parcel) ;
 /*�T���̖{��*/
 solution=solve(parcel) ;
 /*���̏o��*/
 prints(solution) ;
 return 0 ;
}

/****************************/
/*       solve()�֐�  �@    */
/*�@     �T���̖{�́@�@     */
/****************************/
int solve(int parcel [N][2])
{
 int i ;/*�J�Ԃ��̐���*/
 int limit ;/*�T���̏��*/
 int maxvalue=0 ;/*�]���l�̍ő�l*/
 int value ;/*�]���l*/
 int solution ;/*�����*/

 /*�T���͈͂̐ݒ�*/
 limit=pow2n(N) ;
 /*���̒T��*/
 for(i=0;i<limit;++i){
  /*�]���l�̌v�Z*/
  value=calcval(parcel,i) ;
  /*�ő�l�̍X�V*/
  if(value>maxvalue){
   maxvalue=value ;
   solution=i ;
   printf("*** maxvalue %d\n",maxvalue) ;
  }
 }
 return solution ;
}

/****************************/
/*       calcval()�֐�  �@  */
/*�@     �]���l�̌v�Z�@�@   */
/****************************/
int calcval(int parcel[N][2],int i)
{
 int pos ;/*��`�q���̎w��*/
 int value=0 ;/*�]���l*/
 int weight=0 ;/*�d��*/

 /*�e��`�q���𒲂ׂďd�ʂƕ]���l���v�Z*/
 for(pos=0;pos<N;++pos){
  weight+=parcel[pos][0]*((i>>pos)&0x1) ;
  value+=parcel[pos][1]*((i>>pos)&0x1) ;
 }
 /*�v����`�q�̏���*/
 if(weight>=WEIGHTLIMIT) value=0 ;
 return value;
}

/****************************/
/*       pow2n()�֐�    �@  */
/*�@     2�ׂ̂���   �@�@   */
/****************************/
int pow2n(int n)
{
 int pow=1 ;
 for(;n>0;--n)
  pow*=2 ;
 return pow ;
}

/****************************/
/*       prints()�֐�   �@  */
/*�@    �����̏o��   �@   */
/****************************/
void prints(int solution)
{
 int i ;
 for(i=0;i<N;++i)
  printf("%1d ",(solution>>i)&0x1) ;
 printf("\n") ;
}

/****************************/
/*      initparcel()�֐�    */
/*�@    �ו��̏�����   �@   */
/****************************/
void initparcel(int parcel [N][2])
{
 int i=0 ;
 while((i<N) && 
  (scanf("%d %d",&parcel[i][0],&parcel[i][1])!=EOF)){
  ++i ;
 }
}
