/******************************/
/*          sum2.c            */
/*    �a�C���a�����߂�      */
/* �W�����͂��������ǂݎ��,*/
/* �a�Ɠ��a�𒀎��o�͂��܂� */
/* �R���g���[�����ŏI�����܂� */
/* �g����                     */
/* C:\Users\odaka\dl\ch1>sum2 */
/******************************/

/*Visual Studio�Ƃ̌݊����m�� */
#define _CRT_SECURE_NO_WARNINGS

/*�w�b�_�t�@�C���̃C���N���[�h*/
#include <stdio.h>
#include <stdlib.h>

/* �L���萔�̒�`             */
#define BUFSIZE 256  /*���̓o�b�t�@�T�C�Y*/

/****************/
/*  main()�֐�  */
/****************/
int main()
{
 char linebuf[BUFSIZE] ;/*���̓o�b�t�@*/
 double data ;/*���̓f�[�^*/
 double sum=0.0 ;/*�a*/
 double sum2=0.0 ;/*2��a*/

 while(fgets(linebuf,BUFSIZE,stdin)!=NULL){
  /*�s�̓ǂݎ�肪�\�ȊԌJ��Ԃ�*/
  if(sscanf(linebuf,"%lf",&data)!=0){/*�ϊ��ł�����*/
    sum+=data ;
    sum2+=data*data ;
    printf("%lf\t%lf\n",sum,sum2) ;
  }
 }

 return 0 ;
}
