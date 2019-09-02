package com.fabricmonde.salesapp.tracemodel;

public class madewithInfo
        {
           private String mType, mCertification;
            public  madewithInfo()
          {

          }

            public String getmType() {
                return mType;
            }

            public void setmType(String mType) {
                this.mType = mType;
            }

            public String getmCertification() {
                return mCertification;
            }

            public void setmCertification(String mCertification) {
                this.mCertification = mCertification;
            }

            public madewithInfo(String type, String certify)
    {
        this.mType = type;
        this.mCertification = certify;
    }
        }



