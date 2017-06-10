/*********************************************************/
/*                   neuron.c                            */
/*�@�P�̂̐l�H�j���[�����̌v�Z                           */
/* �K���ȏd�݂Ƃ������l��L����l�H�j���[������͋[���܂�*/
/* �g�����@                                              */
/*  \Users\odaka\dl\ch4>neuron                           */
/*********************************************************/

/*Visual Studio�Ƃ̌݊����m�� */
#define _CRT_SECURE_NO_WARNINGS

/* �w�b�_�t�@�C���̃C���N���[�h*/
#include <stdio.h>
#include <stdlib.h>
#include <math.h>


/*�L���萔�̒�`*/
#define INPUTNO 2  /*���͐�*/ 
#define MAXINPUTNO 100    /*�f�[�^�̍ő��*/ 

/*�֐��̃v���g�^�C�v�̐錾*/
double f(double u) ; /*�`�B�֐�*/
void initw(double w[INPUTNO+1]) ;
                         /*�d�݂Ƃ������l�̏�����*/
double forward(double w[INPUTNO+1]
         ,double e[INPUTNO]) ; /*�������̌v�Z*/
int getdata(double e[][INPUTNO]) ;/*�f�[�^�ǂݍ���*/ 
         
/*******************/ 
/*    main()�֐�   */ 
/*******************/ 
int main()
{
 double w[INPUTNO+1] ;/*�d�݂Ƃ������l*/
 double e[MAXINPUTNO][INPUTNO] ;/*�f�[�^�Z�b�g*/
 double o ;/*�o��*/
 int i,j ;/*�J��Ԃ��̐���*/
 int n_of_e ;/*�f�[�^�̌�*/
 
 /*�d�݂̏�����*/
 initw(w) ;

 /*���̓f�[�^�̓ǂݍ���*/
 n_of_e=getdata(e) ;
 printf("�f�[�^�̌�:%d\n",n_of_e) ;
 
 /*�v�Z�̖{��*/
 for(i=0;i<n_of_e;++i){
  printf("%d ",i) ;
  for(j=0;j<INPUTNO;++j)
   printf("%lf ",e[i][j]) ;
  o=forward(w,e[i]) ;
  printf("%lf\n",o) ;
 }

 return 0 ;
}

/**********************/
/*  getdata()�֐�     */
/*�w�K�f�[�^�̓ǂݍ���*/
/**********************/
int getdata(double e[][INPUTNO])
{
 int n_of_e=0 ;/*�f�[�^�Z�b�g�̌�*/
 int j=0 ;/*�J��Ԃ��̐���p*/

 /*�f�[�^�̓���*/
 while(scanf("%lf",&e[n_of_e][j])!=EOF){
  ++ j ;
  if(j>=INPUTNO){/*���̃f�[�^*/
   j=0 ;
   ++n_of_e ;
  }
 }
 return n_of_e ;
}

/**********************/
/*  forward()�֐�     */
/*  �������̌v�Z      */
/**********************/
double forward(double w[INPUTNO+1],double e[INPUTNO])
{
 int i ;/*�J��Ԃ��̐���*/
 double u,o ;/*�r���̌v�Z�lu�Əo��o*/

 /*�v�Z�̖{��*/
 u=0 ;
 for(i=0;i<INPUTNO;++i)
  u+=e[i]*w[i] ;
 u-=w[i] ;/*�������l�̏���*/
 /*�o�͒l�̌v�Z*/
 o=f(u) ;
 return o ;
} 

/**********************/
/*    initw()�֐�     */
/*�@�@�d�݂̏������@�@*/
/**********************/
void initw(double w[INPUTNO+1])
{

 /*�萔���׏d�Ƃ��ė^����*/
 w[0]=1 ;
 w[1]=1 ;
 w[2]=1.5 ;
// w[2]=0.5 ;

} 


/*******************/
/* f()�֐�         */
/* �`�B�֐�        */
/*******************/
double f(double u)
{
 /*�X�e�b�v�֐��̌v�Z*/
 if(u>=0) return 1.0 ;
 else return 0.0 ;
 
 /*�V�O���C�h�֐��̌v�Z*/
// return 1.0/(1.0+exp(-u)) ;
}



