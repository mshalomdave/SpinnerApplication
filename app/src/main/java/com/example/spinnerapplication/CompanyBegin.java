package com.example.spinnerapplication;

public class CompanyBegin {
    int company_id;

    private  String CompanyName="";
    private  String photo ="";
    private  String slogan ="";
    private  String company_no ="",photolastmod;
    protected CompanyBegin(int company_id,String CompanyName,String slogan, String photo, String company_no,String photolastmod) {
        this.company_id=company_id;
        this.CompanyName = CompanyName;
        this.photo = photo;
        this.slogan=slogan;
        this.company_no=company_no;
        this.photolastmod=photolastmod;
    }



    /*********** Get Methods ****************/
    public String getCompanyName()
    {
        return this.CompanyName;
    }
    public String getPhotolastmod()
    {
        return this.photolastmod;
    }
    public String getCompanyNo()
    {
        return this.company_no;
    }
    public int getCompanyId()
    {
        return this.company_id;
    }

    public String getPhoto()
    {
        return this.photo;
    }

    public String getSlogan()
    {
        return this.slogan;
    }
}
