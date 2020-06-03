#include <jni.h>
#include "./javaNativeInterface/net_ggiz_view_eeprom_ComPort.h"
#include <stdio.h>
#include <windows.h>

#define  TEST_OK                  0
#define  ERROR_OPEN_SERIAL_PORT   1
#define  ERROR_V_COMM_STATE       2
#define  ERROR_SET_COMM_STATE     3
#define  ERROR_SET_COMM_TIME_OUTS 4
#define  ERROR_SET_COMM_MASK      5
#define  ERROR_RECEPT             6

DWORD    baudeRateOpt[14] = { CBR_110,
                              CBR_300,
                              CBR_600,
                              CBR_1200,
                              CBR_2400,
                              CBR_4800,
                              CBR_9600,
                              CBR_14400,
                              CBR_19200,
                              CBR_38400,
                              CBR_57600,
                              CBR_115200,
                              CBR_128000,
                              CBR_256000 }; 

DCB           dcb      = {0};
COMMTIMEOUTS  timeOuts = {0};
HANDLE        hComm;
int          SerialBuffer[1024];
int          bufferLen;

unsigned int openCom (char *comID) {		
  hComm = CreateFile( comID,                  
		                  GENERIC_READ | GENERIC_WRITE, 
								      0,                            
								      NULL,                        
							        OPEN_EXISTING,                
		                  0,                           
		                  NULL);          

  if (hComm == INVALID_HANDLE_VALUE)
      return ERROR_OPEN_SERIAL_PORT;
   else 
      return TEST_OK;

}

unsigned int vCommState () {
    BOOL  Status;
    dcb.DCBlength = sizeof (dcb);
    Status = GetCommState (hComm, &dcb);

    return (Status == FALSE ? ERROR_V_COMM_STATE : TEST_OK);
}

unsigned int verSetCommState () {
  BOOL  Status;
  Status =  SetCommState(hComm, &dcb);
  return (Status == FALSE ? ERROR_SET_COMM_STATE : TEST_OK);
}

unsigned int verSetCommTimeouts () {
    BOOL Status;
    Status = SetCommTimeouts(hComm, &timeOuts);
    return (Status == FALSE ? ERROR_SET_COMM_TIME_OUTS : TEST_OK);
}

unsigned int verSetCommMask () {
    BOOL Status;
    Status = SetCommMask(hComm, EV_RXCHAR);
    return (Status == FALSE ? ERROR_SET_COMM_TIME_OUTS : TEST_OK);
}

unsigned int config (char *comID, 
                     unsigned int indexOptBaudrate) {
      
      unsigned int openOk       =  openCom (comID);
      unsigned int verStateComm =  vCommState (); 

  if (openOk == TEST_OK 
      && verStateComm == TEST_OK) {
      
      dcb.BaudRate = CBR_9600;  
      dcb.ByteSize = 8;         
      dcb.StopBits = ONESTOPBIT;
      dcb.Parity   = NOPARITY;
      unsigned int testSetCommState = verSetCommState ();

        if (testSetCommState == TEST_OK) {
             timeOuts.ReadIntervalTimeout          = 50; // milisegundos
             timeOuts.ReadTotalTimeoutConstant     = 50; // milisegundos
             timeOuts.ReadTotalTimeoutMultiplier   = 10; // milisegundos
             timeOuts.WriteTotalTimeoutConstant    = 50; // milisegundos
             timeOuts.WriteTotalTimeoutMultiplier  = 10; // milisegundos
             
             unsigned int testSetCommTimeOuts      = verSetCommTimeouts ();

            if (testSetCommTimeOuts == TEST_OK) {
                return verSetCommMask ();
            } else {
               return testSetCommTimeOuts;
            }

        } else {
           return testSetCommState;
        }

  }   else {
      return verStateComm;
  }

}

unsigned int readCOMM () {
    BOOL  Status;
    DWORD eventMask; 
	char  TempChar;  
	DWORD byteRead;    
	int i  = 0;
    Status = WaitCommEvent(hComm, &eventMask, NULL);

    if (Status == FALSE) {
       return ERROR_RECEPT;
    } else {
       do {
            ReadFile(hComm, &TempChar, sizeof(TempChar), &byteRead, NULL);
            SerialBuffer[i] = (int)TempChar;
            bufferLen = i++;
        } while (byteRead > 0);

        return TEST_OK;  
    }
}


JNIEXPORT jintArray JNICALL Java_net_ggiz_view_eeprom_ComPort_readDataExtern(JNIEnv * env, jobject ob, jint opt){
   
   unsigned int configOk = config ("COM5", 1);
   jintArray result;
   
   if (configOk == TEST_OK) {
      unsigned int  readCommOk = readCOMM ();

      if (readCommOk != TEST_OK) {
         //Adicionar retorno aqui
         //printf ("Problemas na obtencao de dados %d");
      } else {

        int size = bufferLen;
        result   = (*env)->NewIntArray(env, size);
        jint fill[size];
        int i;
        
        for (i = 0; i <= size; i++) {
            fill[i] = SerialBuffer[i];
        }
    
        (*env)->SetIntArrayRegion(env, result, 0, size, fill);
      }

   } else {
       //Adicionar retorno aqui
      //printf ("Problemas na configuracao de iniciacao %d");
   }

  CloseHandle(hComm);
  
  return result;
}

/*void main (void) {

  unsigned int configOk = config ("COM5", 1);
  
  if (configOk == TEST_OK) {
      unsigned int  readCommOk = readCOMM ();

      if (readCommOk != TEST_OK) {
         printf ("Problemas na obtencao de dados %d");
      }

  } else {
      printf ("Problemas na configuracao de iniciacao %d");
  }

  CloseHandle(hComm);

}*/