/*********************************************************/
/*                   nn.c �@�@                           */
/* �P���ȊK�w�^�j���[�����l�b�g�̌v�Z                    */
/* �P�o�͂̃l�b�g���[�N���v�Z���܂��i�w�K�Ȃ��j          */
/* �g�����@                                              */
/*  \Users\odaka\dl\ch4>nn <data.txt                     */
/*********************************************************/

/*Visual Studio�Ƃ̌݊����m�� */
#define _CRT_SECURE_NO_WARNINGS

/* �w�b�_�t�@�C���̃C���N���[�h*/
#include <stdio.h>
#include <stdlib.h>
#include <math.h>


/*�L���萔�̒�`*/
#define INPUTNO 2  /*���͑w�̃Z����*/ 
#define HIDDENNO 2  /*���ԑw�̃Z����*/ 
#define MAXINPUTNO 100    /*�f�[�^�̍ő��*/ 

/*�֐��̃v���g�^�C�v�̐錾*/
double f(double u) ; /*�`�B�֐�*/
void initwh(double wh[HIDDENNO][INPUTNO+1]) ;
                         /*���ԑw�̏d�݂̏�����*/
void initwo(double wo[HIDDENNO+1]) ;/*�o�͑w�̏d�݂̏�����*/
double forward(double wh[HIDDENNO][INPUTNO+1]
         ,double wo[HIDDENNO+1],double hi[]
         ,double e[INPUTNO]) ; /*�������̌v�Z*/
int getdata(double e[][INPUTNO]) ;/*�f�[�^�ǂݍ���*/ 
         
/*******************/ 
/*    main()�֐�   */ 
/*******************/ 
int main()
{
 double wh[HIDDENNO][INPUTNO+1] ;/*���ԑw�̏d��*/
 double wo[HIDDENNO+1] ;/*�o�͑w�̏d��*/
 double e[MAXINPUTNO][INPUTNO] ;/*�f�[�^�Z�b�g*/
 double hi[HIDDENNO+1] ;/*���ԑw�̏o��*/
 double o ;/*�o��*/
 int i,j ;/*�J��Ԃ��̐���*/
 int n_of_e ;/*�f�[�^�̌�*/
 
 /*�d�݂̏�����*/
 initwh(wh) ;
 initwo(wo) ;

 /*���̓f�[�^�̓ǂݍ���*/
 n_of_e=getdata(e) ;
 printf("�f�[�^�̌�:%d\n",n_of_e) ;
 
 /*�v�Z�̖{��*/
 for(i=0;i<n_of_e;++i){
  printf("%d ",i) ;
  for(j=0;j<INPUTNO;++j)
   printf("%lf ",e[i][j]) ;
  o=forward(wh,wo,hi,e[i]) ;
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
double forward(double wh[HIDDENNO][INPUTNO+1]
 ,double wo[HIDDENNO+1],double hi[],double e[INPUTNO])
{
 int i,j ;/*�J��Ԃ��̐���*/
 double u ;/*�d�ݕt���a�̌v�Z*/
 double o ;/*�o�͂̌v�Z*/

 /*hi�̌v�Z*/
 for(i=0;i<HIDDENNO;++i){
  u=0 ;/*�d�ݕt���a�����߂�*/
  for(j=0;j<INPUTNO;++j)
   u+=e[j]*wh[i][j] ; 
  u-=wh[i][j] ;/*�������l�̏���*/
  hi[i]=f(u) ;
 }
 /*�o��o�̌v�Z*/
 o=0 ;
 for(i=0;i<HIDDENNO;++i)
  o+=hi[i]*wo[i] ;
 o-=wo[i] ;/*�������l�̏���*/
 
 return f(o) ;
} 


//**********************/
/*    initwh()�֐�    */
/*���ԑw�̏d�݂̏�����*/
/**********************/
void initwh(double wh[HIDDENNO][INPUTNO+1])
{
 
 /*�׏d��萔�Ƃ��ė^����*/
 wh[0][0]=-2 ;
 wh[0][1]=3 ;
 wh[0][2]=-1 ;
 wh[1][0]=-2 ;
 wh[1][1]=1 ;
 wh[1][2]=0.5 ;

} 

/**********************/
/*    initwo()�֐�    */
/*�o�͑w�̏d�݂̏�����*/
/**********************/
void initwo(double wo[HIDDENNO+1])
{
 /*�׏d��萔�Ƃ��ė^����*/
 wo[0]=-60 ;
 wo[1]=94 ;
 wo[2]=-1 ;
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



