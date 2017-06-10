/*********************************************************/
/*               simplecnn.c                             */
/* ��ݍ��݃j���[�����l�b�g�̊�{�\���f�����X�g���[�V����*/
/* CNN�̊�{�\��(���g�̂݁j�������܂�                    */
/* �g�����@                                              */
/*  \Users\odaka\dl\ch5>simplecnn < data1.txt            */
/*********************************************************/

/*Visual Studio�Ƃ̌݊����m�� */
#define _CRT_SECURE_NO_WARNINGS

/* �w�b�_�t�@�C���̃C���N���[�h*/
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

/*�L���萔�̒�`*/
#define INPUTSIZE 11  /*���͐�*/ 
#define FILTERSIZE 3 /*�t�B���^�̑傫��*/
#define FILTERNO 2 /*�t�B���^�̌�*/
#define POOLSIZE 3 /*�v�[�����O�T�C�Y*/
#define POOLOUTSIZE 3/*�v�[�����O�̏o�̓T�C�Y*/
#define MAXINPUTNO 100    /*�w�K�f�[�^�̍ő��*/ 
#define SEED 65535    /*�����̃V�[�h*/ 
#define LIMIT 0.001    /*�덷�̏���l*/ 
#define BIGNUM 100    /*�덷�̏����l*/ 
#define HIDDENNO 3  /*���ԑw�̃Z����*/ 
#define ALPHA  10  /*�w�K�W��*/ 

/*�֐��̃v���g�^�C�v�̐錾*/
void conv(double filter[FILTERSIZE][FILTERSIZE]
   ,double e[][INPUTSIZE]
   ,double convout[][INPUTSIZE]) ; /*��ݍ��݂̌v�Z*/
double calcconv(double filter[][FILTERSIZE]
               ,double e[][INPUTSIZE],int i,int j) ;
                               /*  �t�B���^�̓K�p  */
void pool(double convout[][INPUTSIZE]
         ,double poolout[][POOLOUTSIZE]) ; 
             /*�v�[�����O�̌v�Z*/           
double maxpooling(double convout[][INPUTSIZE]
                 ,int i,int j) ;/* �ő�l�v�[�����O */
int getdata(double e[][INPUTSIZE][INPUTSIZE],int r[]) ;/*�f�[�^�ǂݍ���*/ 
void showdata(double e[][INPUTSIZE][INPUTSIZE],int t[]
             ,int n_of_e) ;/*�f�[�^�\��*/ 
void initfilter(double filter[FILTERNO][FILTERSIZE][FILTERSIZE]) ;
                /*�t�B���^�̏�����*/
double drnd(void) ;/* �����̐���     */
double f(double u) ; /*�`�B�֐��i�V�O���C�h�֐��j*/
void initwh(double wh[HIDDENNO][POOLOUTSIZE*POOLOUTSIZE*FILTERNO+1]) ;
                         /*���ԑw�̏d�݂̏�����*/
void initwo(double wo[HIDDENNO+1]) ;/*�o�͑w�̏d�݂̏�����*/
double forward(double wh[HIDDENNO][POOLOUTSIZE*POOLOUTSIZE*FILTERNO+1]
         ,double wo[HIDDENNO+1],double hi[]
         ,double e[POOLOUTSIZE*POOLOUTSIZE*FILTERNO+1]) ; /*�������̌v�Z*/
void olearn(double wo[HIDDENNO+1],double hi[]
         ,double e[POOLOUTSIZE*POOLOUTSIZE*FILTERNO+1],double o) ; /*�o�͑w�̏d�݂̒���*/
void hlearn(double wh[HIDDENNO][POOLOUTSIZE*POOLOUTSIZE*FILTERNO+1]
         ,double wo[HIDDENNO+1],double hi[]
         ,double e[POOLOUTSIZE*POOLOUTSIZE*FILTERNO+1],double o) ; /*���ԑw�̏d�݂̒���*/
double f(double u) ; /*�`�B�֐��i�V�O���C�h�֐��j*/
void print(double wh[HIDDENNO][POOLOUTSIZE*POOLOUTSIZE*FILTERNO+1]
          ,double wo[HIDDENNO+1]) ; /*���ʂ̏o��*/
          
/*******************/ 
/*    main()�֐�   */ 
/*******************/ 
int main()
{
 double filter[FILTERNO][FILTERSIZE][FILTERSIZE] ;
                            /*�t�B���^*/
 double e[MAXINPUTNO][INPUTSIZE][INPUTSIZE] ;/*���̓f�[�^*/
 int t[MAXINPUTNO] ;/*���t�f�[�^*/
 double convout[INPUTSIZE][INPUTSIZE]={0} ;/*��ݍ��ݏo��*/
 double poolout[POOLOUTSIZE][POOLOUTSIZE] ;/*�o�̓f�[�^*/
 int i,j,m,n ;/*�J��Ԃ��̐���*/
 int n_of_e ;/*�w�K�f�[�^�̌�*/
 double err=BIGNUM ;/*�덷�̕]��*/
 int count=0 ;/*�J��Ԃ��񐔂̃J�E���^*/
 double ef[POOLOUTSIZE*POOLOUTSIZE*FILTERNO+1] ;/*�S�����w�ւ̓��̓f�[�^*/
 double o ;/*�ŏI�o��*/
 double hi[HIDDENNO+1] ;/*���ԑw�̏o��*/
 double wh[HIDDENNO][POOLOUTSIZE*POOLOUTSIZE*FILTERNO+1] ;/*���ԑw�̏d��*/
 double wo[HIDDENNO+1] ;/*�o�͑w�̏d��*/
 
 /*�����̏�����*/
 srand(SEED) ;
 
 /*�t�B���^�[�̏�����*/
 initfilter(filter) ;
 
 /*�S�����w�̏d�݂̏�����*/
 initwh(wh) ;/*���ԑw�̏d�݂̏�����*/
 initwo(wo) ;/*�o�͑w�̏d�݂̏�����*/
 
 /*���̓f�[�^�̓ǂݍ���*/
 n_of_e=getdata(e,t) ;
 showdata(e,t,n_of_e) ;
 
  /*�w�K*/
 while(err>LIMIT){
  err=0.0 ;
  for(i=0;i<n_of_e;++i){/*�w�K�f�[�^���̌J��Ԃ�*/
   for(j=0;j<FILTERNO;++j){/*�t�B���^���̌J��Ԃ�*/
    /*��ݍ��݂̌v�Z*/
    conv(filter[j],e[i],convout) ;
    /*�v�[�����O�̌v�Z*/
    pool(convout,poolout) ;
    /*�v�[�����O�o�͂�S�����w�̓��͂փR�s�[*/
    for(m=0;m<POOLOUTSIZE;++m)
     for(n=0;n<POOLOUTSIZE;++n)
      ef[j*POOLOUTSIZE*POOLOUTSIZE+POOLOUTSIZE*m+n]
           =poolout[m][n] ;
    ef[POOLOUTSIZE*POOLOUTSIZE*FILTERNO]=t[i] ;/*���t�f�[�^*/
   }
   /*�������̌v�Z*/
   o=forward(wh,wo,hi,ef) ;
   /*�o�͑w�̏d�݂̒���*/
   olearn(wo,hi,ef,o) ;
   /*���ԑw�̏d�݂̒���*/
   hlearn(wh,wo,hi,ef,o) ;
   /*�덷�̐ώZ*/
   err+=(o-t[i])*(o-t[i]) ;
  }
  ++count ;
  /*�덷�̏o��*/
  fprintf(stderr,"%d\t%lf\n",count,err) ;
 }/*�w�K�I��*/
 
 printf("\n***Results***\n") ;
 /*�����׏d�̏o��*/
 printf("Weights\n") ;
 print(wh,wo) ; 

 /*���t�f�[�^�ɑ΂���o��*/
 printf("Network output\n") ;
 printf("#\tteacher\toutput\n") ;
 for(i=0;i<n_of_e;++i){
  printf("%d\t%d\t",i,t[i]) ;
  for(j=0;j<FILTERNO;++j){/*�t�B���^���̌J��Ԃ�*/
    /*��ݍ��݂̌v�Z*/
    conv(filter[j],e[i],convout) ;
    /*�v�[�����O�̌v�Z*/
    pool(convout,poolout) ;
    /*�v�[�����O�o�͂�S�����w�̓��͂փR�s�[*/
    for(m=0;m<POOLOUTSIZE;++m)
     for(n=0;n<POOLOUTSIZE;++n)
      ef[j*POOLOUTSIZE*POOLOUTSIZE+POOLOUTSIZE*m+n]
           =poolout[m][n] ;
    ef[POOLOUTSIZE*POOLOUTSIZE*FILTERNO]=t[i] ;/*���t�f�[�^*/
   }
   o=forward(wh,wo,hi,ef) ;
  printf("%lf\n",o) ;
 }

 return 0 ;
}

/**********************/
/*   print()�֐�      */
/*   ���ʂ̏o��       */
/**********************/
void print(double wh[HIDDENNO][POOLOUTSIZE*POOLOUTSIZE*FILTERNO+1]
          ,double wo[HIDDENNO+1])
{
 int i,j ;/*�J��Ԃ��̐���*/

 for(i=0;i<HIDDENNO;++i)
  for(j=0;j<POOLOUTSIZE*POOLOUTSIZE*FILTERNO+1;++j)
   printf("%lf ",wh[i][j]) ;
 printf("\n") ;
 for(i=0;i<HIDDENNO+1;++i)
  printf("%lf ",wo[i]) ;
 printf("\n") ;
} 

/**********************/
/*  hlearn()�֐�      */
/*  ���ԑw�̏d�݊w�K  */
/**********************/
void hlearn(double wh[HIDDENNO][POOLOUTSIZE*POOLOUTSIZE*FILTERNO+1]
    ,double wo[HIDDENNO+1]
    ,double hi[],double e[POOLOUTSIZE*POOLOUTSIZE*FILTERNO+1],double o)
{
 int i,j ;/*�J��Ԃ��̐���*/
 double dj ;/*���ԑw�̏d�݌v�Z�ɗ��p*/

 for(j=0;j<HIDDENNO;++j){/*���ԑw�̊e�Z��j��Ώ�*/
  dj=hi[j]*(1-hi[j])*wo[j]*(e[POOLOUTSIZE*POOLOUTSIZE*FILTERNO]-o)*o*(1-o) ;
  for(i=0;i<POOLOUTSIZE*POOLOUTSIZE*FILTERNO;++i)/*i�Ԗڂ̏d�݂�����*/
   wh[j][i]+=ALPHA*e[i]*dj ;
  wh[j][i]+=ALPHA*(-1.0)*dj ;/*�������l�̊w�K*/
 }
}

/**********************/
/*  olearn()�֐�      */
/*  �o�͑w�̏d�݊w�K  */
/**********************/
void olearn(double wo[HIDDENNO+1]
    ,double hi[],double e[POOLOUTSIZE*POOLOUTSIZE*FILTERNO+1],double o)
{
 int i ;/*�J��Ԃ��̐���*/
 double d ;/*�d�݌v�Z�ɗ��p*/

 d=(e[POOLOUTSIZE*POOLOUTSIZE*FILTERNO]-o)*o*(1-o) ;/*�덷�̌v�Z*/
 for(i=0;i<HIDDENNO;++i){
  wo[i]+=ALPHA*hi[i]*d ;/*�d�݂̊w�K*/
 }
 wo[i]+=ALPHA*(-1.0)*d ;/*�������l�̊w�K*/
 
} 

/**********************/
/*  forward()�֐�     */
/*  �������̌v�Z      */
/**********************/
double forward(double wh[HIDDENNO][POOLOUTSIZE*POOLOUTSIZE*FILTERNO+1]
 ,double wo[HIDDENNO+1],double hi[],double e[POOLOUTSIZE*POOLOUTSIZE*FILTERNO+1])
{
 int i,j ;/*�J��Ԃ��̐���*/
 double u ;/*�d�ݕt���a�̌v�Z*/
 double o ;/*�o�͂̌v�Z*/

 /*hi�̌v�Z*/
 for(i=0;i<HIDDENNO;++i){
  u=0 ;/*�d�ݕt���a�����߂�*/
  for(j=0;j<POOLOUTSIZE*POOLOUTSIZE*FILTERNO;++j)
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

/**********************/
/*    initwo()�֐�    */
/*���ԑw�̏d�݂̏�����*/
/**********************/
void initwh(double wh[][POOLOUTSIZE*POOLOUTSIZE*FILTERNO+1])
{
 int i,j ;/*�J��Ԃ��̐���*/

 /*�����ɂ��d�݂̌���*/ 
 for(i=0;i<HIDDENNO;++i)
  for(j=0;j<POOLOUTSIZE*POOLOUTSIZE*FILTERNO+1;++j)
   wh[i][j]=drnd() ;
} 

/**********************/
/*    initwo()�֐�    */
/*�o�͑w�̏d�݂̏�����*/
/**********************/
void initwo(double wo[])
{
 int i ;/*�J��Ԃ��̐���*/

 /*�����ɂ��d�݂̌���*/
 for(i=0;i<HIDDENNO+1;++i)
   wo[i]=drnd() ;
} 

/**********************/
/*  initfilter()�֐�  */
/* �@�t�B���^�̏����� */
/**********************/
void initfilter(double filter[FILTERNO][FILTERSIZE][FILTERSIZE])
{
 int i,j,k ;/*�J��Ԃ��̐���*/
 
 for(i=0;i<FILTERNO;++i)
  for(j=0;j<FILTERSIZE;++j)
   for(k=0;k<FILTERSIZE;++k)
    filter[i][j][k]=drnd() ;
} 

/*******************/
/* drnd()�֐�      */
/* �����̐���      */
/*******************/
double drnd(void)
{
 double rndno ;/*������������*/

 while((rndno=(double)rand()/RAND_MAX)==1.0) ;
 rndno=rndno*2-1 ;/*-1����1�̊Ԃ̗����𐶐�*/
 return rndno; 
}

/**********************/
/*  pool()�֐�        */
/* �v�[�����O�̌v�Z   */
/**********************/
void pool(double convout[][INPUTSIZE]
         ,double poolout[][POOLOUTSIZE]) 
{
 int i,j ;/*�J��Ԃ��̐���*/

 for(i=0;i<POOLOUTSIZE;++i)
  for(j=0;j<POOLOUTSIZE;++j)
   poolout[i][j]=maxpooling(convout,i,j) ;
}
 
/**********************/
/* maxpooling()�֐�   */
/* �ő�l�v�[�����O   */
/**********************/
double maxpooling(double convout[][INPUTSIZE]
                 ,int i,int j)
{
 int m,n ;/*�J��Ԃ��̐���p*/
 double max ;/*�ő�l*/
 int halfpool=POOLSIZE/2 ;/*�v�[�����O�̃T�C�Y��1/2*/
 
 max
 =convout[i*POOLOUTSIZE+1+halfpool][j*POOLOUTSIZE+1+halfpool];
 for(m=POOLOUTSIZE*i+1;m<=POOLOUTSIZE*i+1+(POOLSIZE-halfpool);++m)
  for(n=POOLOUTSIZE*j+1;n<=POOLOUTSIZE*j+1+(POOLSIZE-halfpool);++n)
   if(max<convout[m][n]) max=convout[m][n] ;

 return max ;
}
               
/**********************/
/* showdata()�֐�     */
/*���̓f�[�^�̕\���@�@*/
/**********************/
void showdata(double e[][INPUTSIZE][INPUTSIZE],int t[],int n_of_e)
{
 int i=0,j=0,k=0 ;/*�J��Ԃ��̐���p*/

 /*�f�[�^�̕\��*/
 for(i=0;i<n_of_e;++i){
  printf("N=%d category=%d\n",i,t[i]) ;
  for(j=0;j<INPUTSIZE;++j){
   for(k=0;k<INPUTSIZE;++k)
    printf("%.3lf ",e[i][j][k]) ;
   printf("\n") ;
  }
  printf("\n") ;
 }
}
             
/**********************/
/*  getdata()�֐�     */
/*���̓f�[�^�̓ǂݍ���*/
/**********************/
int getdata(double e[][INPUTSIZE][INPUTSIZE],int t[])
{
 int i=0,j=0,k=0 ;/*�J��Ԃ��̐���p*/

 /*�f�[�^�̓���*/
 while(scanf("%d",&t[i])!=EOF){/*���t�f�[�^�̓ǂݍ���*/
  /*�摜�f�[�^�̓ǂݍ���*/
  while(scanf("%lf",&e[i][j][k])!=EOF){
   ++ k ;
   if(k>=INPUTSIZE){/*���̃f�[�^*/
    k=0 ;
    ++j ;
    if(j>=INPUTSIZE) break ;/*���͏I��*/
   }
  }
  j=0; k=0 ;
  ++i ; 
 }
 return i ;
}

/**********************/
/*  conv()�֐�        */
/*  ��ݍ��݂̌v�Z    */
/**********************/
void conv(double filter[][FILTERSIZE]
         ,double e[][INPUTSIZE],double convout[][INPUTSIZE])
{
 int i=0,j=0 ;/*�J��Ԃ��̐���p*/
 int startpoint=FILTERSIZE/2 ;/*��ݍ��ݔ͈͂̉���*/

 for(i=startpoint;i<INPUTSIZE-startpoint;++i)
  for(j=startpoint;j<INPUTSIZE-startpoint;++j)
   convout[i][j]=calcconv(filter,e,i,j) ;
}

/**********************/
/*  calcconv()�֐�    */
/*  �t�B���^�̓K�p    */
/**********************/
double calcconv(double filter[][FILTERSIZE]
             ,double e[][INPUTSIZE],int i,int j)
{
 int m,n ;/*�J��Ԃ��̐���p*/
 double sum=0 ;/*�a�̒l*/
 
 for(m=0;m<FILTERSIZE;++m)
  for(n=0;n<FILTERSIZE;++n)
   sum+=e[i-FILTERSIZE/2+m][j-FILTERSIZE/2+n]*filter[m][n];
   
 return sum ;
}

/*******************/
/* f()�֐�         */
/* �`�B�֐�        */
/*(�V�O���C�h�֐�) */
/*******************/
double f(double u)
{
 return 1.0/(1.0+exp(-u)) ;
}

