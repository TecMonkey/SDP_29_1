package com.example.utshelps.model;

import com.example.utshelps.util.JsonKeys;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by yaseen on 4/10/16.
 */

public class Student {

    // Personal Details
    @SerializedName(JsonKeys.STUDENT_ID)                private String mStudentId;
    @SerializedName(JsonKeys.FIRST_NAME)                private String mFirstName;
    @SerializedName(JsonKeys.LAST_NAME)                 private String mLastName;
    @SerializedName(JsonKeys.DOB)                       private Date mDateOfBirth;
    @SerializedName(JsonKeys.PREFERRED_NAME)            private String mPreferredName;
    @SerializedName(JsonKeys.CONTACT_NUMBER)            private String mContactNumber;
    @SerializedName(JsonKeys.GENDER)                    private String mGender;
    @SerializedName(JsonKeys.FIRST_LANGUAGE)            private String mFirstLanguage;
    @SerializedName(JsonKeys.COUNTRY_OF_ORIGIN)         private String mCountryOfOrigin;

    // Degree Details
    @SerializedName(JsonKeys.DEGREE_TYPE)               private String mDegreeType;
    @SerializedName(JsonKeys.DEGREE_NAME)               private String mDegreeName;
    @SerializedName(JsonKeys.DEGREE_CODE)               private String mDegreeCode;
    @SerializedName(JsonKeys.DEGREE_STATUS)             private String mDegreeStatus;
    @SerializedName(JsonKeys.DEGREE_YEARS)              private int mDegreeYears;

    // Educational Background
    @SerializedName(JsonKeys.HSC)                       private boolean mHsc;
    @SerializedName(JsonKeys.HSC_MARK)                  private Integer mHscMark;
    @SerializedName(JsonKeys.IELTS)                     private boolean mIelts;
    @SerializedName(JsonKeys.IELTS_MARK)                private Integer mIeltsMark;
    @SerializedName(JsonKeys.TOEFL)                     private boolean mToefl;
    @SerializedName(JsonKeys.TOEFL_MARK)                private Integer mToeflMark;
    @SerializedName(JsonKeys.TAFE)                      private boolean mTafe;
    @SerializedName(JsonKeys.TAFE_MARK)                 private Integer mTafeMark;
    @SerializedName(JsonKeys.CULT)                      private boolean mCult;
    @SerializedName(JsonKeys.CULT_MARK)                 private Integer mCultMark;
    @SerializedName(JsonKeys.INSEARCH_DEEP)             private boolean mInsearchDeep;
    @SerializedName(JsonKeys.INSEARCH_DEEP_MARK)        private Integer mInsearchDeepMark;
    @SerializedName(JsonKeys.INSEARCH_DIPLOMA)          private boolean mInsearchDiploma;
    @SerializedName(JsonKeys.INSEARCH_DIPLOMA_MARK)     private Integer mInsearchDiplomaMark;
    @SerializedName(JsonKeys.FOUNDATION_COURSE)         private boolean mFoundationCourse;
    @SerializedName(JsonKeys.FOUNDATION_COURSE_MARK)    private Integer mFoundationCourseMark;

    public static final String GENDER_MALE = "M";
    public static final String GENDER_FEMALE = "F";
    public static final String GENDER_X = "X";

    public static final String DEGREE_UNDERGRAD = "U";
    public static final String DEGREE_POSTGRAD = "P";

    public String getStudentId() {
        return mStudentId;
    }

    public void setStudentId(String mStudentId) {
        this.mStudentId = mStudentId;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    public Date getDateOfBirth() {
        return mDateOfBirth;
    }

    public void setDateOfBirth(Date mDateOfBirth) {
        this.mDateOfBirth = mDateOfBirth;
    }

    public String getPreferredName() {
        return mPreferredName;
    }

    public void setPreferredName(String mPreferredName) {
        this.mPreferredName = mPreferredName;
    }

    public String getContactNumber() {
        return mContactNumber;
    }

    public void setContactNumber(String mContactNumber) {
        this.mContactNumber = mContactNumber;
    }

    public String getGender() {
        return mGender;
    }

    public void setGender(String mGender) {
        this.mGender = mGender;
    }

    public String getFirstLanguage() {
        return mFirstLanguage;
    }

    public void setFirstLanguage(String mFirstLanguage) {
        this.mFirstLanguage = mFirstLanguage;
    }

    public String getCountryOfOrigin() {
        return mCountryOfOrigin;
    }

    public void setCountryOfOrigin(String mCountryOfOrigin) {
        this.mCountryOfOrigin = mCountryOfOrigin;
    }

    public String getDegreeType() {
        return mDegreeType;
    }

    public void setDegreeType(String mDegreeType) {
        this.mDegreeType = mDegreeType;
    }

    public String getDegreeName() {
        return mDegreeName;
    }

    public void setDegreeName(String mDegreeName) {
        this.mDegreeName = mDegreeName;
    }

    public String getDegreeCode() {
        return mDegreeCode;
    }

    public void setDegreeCode(String mDegreeCode) {
        this.mDegreeCode = mDegreeCode;
    }

    public String getDegreeStatus() {
        return mDegreeStatus;
    }

    public void setDegreeStatus(String mDegreeStatus) {
        this.mDegreeStatus = mDegreeStatus;
    }

    public int getDegreeYears() {
        return mDegreeYears;
    }

    public void setDegreeYears(int mDegreeYears) {
        this.mDegreeYears = mDegreeYears;
    }

    public boolean getHsc() {
        return mHsc;
    }

    public void setHsc(boolean mHsc) {
        this.mHsc = mHsc;
    }

    public Integer getHscMark() {
        return mHscMark;
    }

    public void setHscMark(Integer mHscMark) {
        this.mHscMark = mHscMark;
    }

    public boolean getIelts() {
        return mIelts;
    }

    public void setIelts(boolean mIelts) {
        this.mIelts = mIelts;
    }

    public Integer getIeltsMark() {
        return mIeltsMark;
    }

    public void setIeltsMark(Integer mIeltsMark) {
        this.mIeltsMark = mIeltsMark;
    }

    public boolean getToefl() {
        return mToefl;
    }

    public void setToefl(boolean mToefl) {
        this.mToefl = mToefl;
    }

    public Integer getToeflMark() {
        return mToeflMark;
    }

    public void setToeflMark(Integer mToeflMark) {
        this.mToeflMark = mToeflMark;
    }

    public boolean getTafe() {
        return mTafe;
    }

    public void setTafe(boolean mTafe) {
        this.mTafe = mTafe;
    }

    public Integer getTafeMark() {
        return mTafeMark;
    }

    public void setTafeMark(Integer mTafeMark) {
        this.mTafeMark = mTafeMark;
    }

    public boolean getCult() {
        return mCult;
    }

    public void setCult(boolean mCult) {
        this.mCult = mCult;
    }

    public Integer getCultMark() {
        return mCultMark;
    }

    public void setCultMark(Integer mCultMark) {
        this.mCultMark = mCultMark;
    }

    public boolean getInsearchDeep() {
        return mInsearchDeep;
    }

    public void setInsearchDeep(boolean mInsearchDeep) {
        this.mInsearchDeep = mInsearchDeep;
    }

    public Integer getInsearchDeepMark() {
        return mInsearchDeepMark;
    }

    public void setInsearchDeepMark(Integer mInsearchDeepMark) {
        this.mInsearchDeepMark = mInsearchDeepMark;
    }

    public boolean getInsearchDiploma() {
        return mInsearchDiploma;
    }

    public void setInsearchDiploma(boolean mInsearchDiploma) {
        this.mInsearchDiploma = mInsearchDiploma;
    }

    public Integer getInsearchDiplomaMark() {
        return mInsearchDiplomaMark;
    }

    public void setInsearchDiplomaMark(Integer mInsearchDiplomaMark) {
        this.mInsearchDiplomaMark = mInsearchDiplomaMark;
    }

    public boolean getFoundationCourse() {
        return mFoundationCourse;
    }

    public void setFoundationCourse(boolean mFoundationCourse) {
        this.mFoundationCourse = mFoundationCourse;
    }

    public Integer getFoundationCourseMark() {
        return mFoundationCourseMark;
    }

    public void setFoundationCourseMark(Integer mFoundationCourseMark) {
        this.mFoundationCourseMark = mFoundationCourseMark;
    }
}
