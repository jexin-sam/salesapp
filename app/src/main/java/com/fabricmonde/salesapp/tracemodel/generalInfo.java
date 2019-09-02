package com.fabricmonde.salesapp.tracemodel;

public  class generalInfo{
   private String gCompanyname,gState;

    public generalInfo()
    {

    }


    public generalInfo(String companyname, String state)
   {
     this.gCompanyname = companyname;
     this.gState = state;
   }

    public String getgCompanyname() {
        return gCompanyname;
    }

    public void setgCompanyname(String gCompanyname) {
        this.gCompanyname = gCompanyname;
    }

    public String getgState() {
        return gState;
    }

    public void setgState(String gState) {
        this.gState = gState;
    }
}
