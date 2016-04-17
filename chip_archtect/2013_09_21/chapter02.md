# ��2�� Opteron�̕��������_���j�b�g

- 2.1 ���������_�̃��l�[�����W�X�^�t�@�C��
- 2.2 ���������_���l�[���X�e�[�W1 : x87�̃X�^�b�N������FP���W�X�^�t�@�C���ւ̃}�b�s���O
- 2.3 ���������_���l�[���X�e�[�W2 : �ʏ�̃��W�X�^���l�[�~���O
- 2.4 ���������_���߃X�P�W���[��
- 2.5 5�|�[�g�ǂݍ��݂�5�|�[�g�������݂̕��������_���l�[�����W�X�^�t�@�C��
- 2.6 ���������_���Z���j�b�g
- 2.7 �ϊ��ƕ��ރ��j�b�g
- 2.8 x87��ԏ��� : FCOMI/FCMOV �� FCOM/FSTSW�y�A

![Opteron's Floating Point Processing Unit's](Opteron_FloatPnt_Core.jpg)

# 2.1 ���������_�̃��l�[�����W�X�^�t�@�C��

Opteron�̕��������_���l�[�����W�X�^�t�@�C���́A88����120�G���g���ɑ������Ă���B
���̃��l�[�����W�X�^�t�@�C���͌��t�ʂ�̈Ӗ��̃��W�X�^�t�@�C���ł���B
�P��̃G���e�B�e�B�������Ă���A���ׂẴA�[�L�e�N�`���I��(�񓊋@�I��)�l�ƁA���߃Z�b�g�ɂ���`���ꂽ���W�X�^�̓��@�I�Ȓl��ێ����Ă���B

Opteron�͍ēx72�̓��@�I�Ȗ��߂��i�[���邱�Ƃ��ł���B
AthlonXP�R�A�ɂ��A���@�I�Ȗ��߂̃T�|�[�g��72���߂���56���߂ɍ팸���ꂽ�B
AthlonXP�ł�SSE�̂��߂�128��XMM���W�X�^�t�@�C�����܂܂�Ă��邪�A88�̃��l�[�����W�X�^�t�@�C���̐��������邱�Ƃ͂Ȃ������B

128bit��XMM���W�X�^�̓��l�[�����W�X�^�t�@�C������2�̃G���g�����g�p����B
����������Opteron��16��XMM�A�[�L�e�N�`��(���^�C�A����)���W�X�^��ێ����邽�߂�32�G���g���𗘗p����B
����ɂ��A88+32�G���g����120�G���g���ƂȂ�B

120�G���g���̂���40�G���g���̓A�[�L�e�N�`����(�񓊋@�I��)���W�X�^�̏�Ԃ�ێ����邽�߂Ɏg�p�����B
32�G���g����16��XMM���W�X�^�p�ł���B�c���8��8��x87/MMX���W�X�^�p�ł���B

�����8�̃��W�X�^�G���g�����A�}�C�N���R�[�h�̃X�N���b�`���W�X�^�Ƃ��Ďg�p����B
����͎��X�}�C�N���A�[�L�e�N�`�����W�X�^�ƌĂ΂��B
�����̃��W�X�^�͖��߃Z�b�g�Ƃ��Ă͒�`����Ă��炸�A�v���O���}����͒��ڌ��邱�Ƃ͂ł��Ȃ��B
�����̃��W�X�^�̓}�C�N���R�[�h���A�O�p�֐���ΐ��֐��Ȃǂ̕��G�Ȍv�Z���s�����߂ɗ��p�����B

48(40+8)�G���g���ɂ���`�����v���Z�b�T�̃A�[�L�e�N�`���I�ȏ�Ԃ́A�u�A�[�L�e�N�`���^�O�A���C(Architectural Tag Array)�v
�Ƃ��Ē�`����Ă���B
���̃G���g���́A48�̃A�[�L�e�N�`���I�ȃ��W�X�^�G���g���̍ŐV�́u���@�I�ȁv�l��ێ����Ă���A�u�t���[�`���[�t�@�C���^�O�A���C
(Future File Tag Array)�v�ƌĂ΂��B

�v���Z�b�T�̓��@�I�ȏ�Ԃ́A����\�����O�̔����ɂ��������邱�Ƃ�����B
����̓t���[�`���[�t�@�C����48�G���g�����A�[�L�e�N�`���^�O�A���C�ŏ㏑�����邱�ƂŎ��������B

���l�[�����W�X�^�t�@�C����90bit���ł���B
���������_�̃f�[�^�͑S�̂�90bit�܂Ŋg�������(68bit�Ɖ������A18�r�b�g�̎w�����A1�r�b�g�̕����r�b�g�A3�r�b�g�̕��ރr�b�g�ł���)�B
3�̕��ރr�b�g�ς́A���������_���̏�񂪕t�������B
���̕��ރr�b�g�́A�񕂓������_��(����)�ȂǁA���l�[�����W�X�^�t�@�C���ɏ������ލۂɊg������K�v�̂Ȃ��l�����ʂ���Ƃ��Ȃǂɗ��p�����B

|    | The 120 registers                  |   |    | The 90 bit registers              |   |   | Definition of the 3bit Class Code  |
|----|------------------------------------|---|----|-----------------------------------|---|---|------------------------------------|
|    | non speculative registers:         |   |    | subdivision of the 90 bits for FP |   | 0 | Zero                               |
| 8  | FP/MMX registers(arch.)            |   | 68 | Mantisse bits                     |   | 1 | Inifinity                          |
| 32 | SSE/SSE2 registers(arch.)          |   | 18 | Exponent bits                     |   | 2 | Quit NAN (Not A Number)            |
| 8  | Micro Code Scratch Registers(arch) |   | 1  | Sign bit                          |   | 3 | Signaling NAN (Not A Number)       |
|    | speculative registers              |   | 3  | Class Code bits                   |   | 4 | Denormal (very small FP number)    |
| 8  | FP/MMX registers(latest)           |   |    |                                   |   | 5 | MMX/MMX (non FP contents)          |
| 32 | SSE/SSE2 registers(lates)          |   |    |                                   |   | 6 | Normal (FP number, not very small) |
| 8  | Micro Code Scratch reg.(latest)    |   |    |                                   |   | 7 | Unsupported                        |
| 24 | Renaming speculative               |   |    |                                   |   |   |                                    |

![Opteron's Floating Point Core](Opteron_FloatPnt_Core_Ill.jpg)

