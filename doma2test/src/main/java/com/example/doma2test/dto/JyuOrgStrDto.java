package com.example.doma2test.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class JyuOrgStrDto implements Serializable {
    private static final long serialVersionUID = 1L; // 一意のIDを定義

    // 一部項目は未使用（entityとﾚｲｱｳﾄを合わせたい為）
    private String jyuno;
    private String toriCd;
    private String toriNm;
    private String braCd;
    private String braNm;
    private String hatDate;
    private String syuDate;
    private String nouDate;
    private String denNo;
    private String tokCd;
    private String tokNm;
    private String ukebaCd;
    private String sokCd;
    private String sokNm;
    private String haisoCd;
    private String haisoNm;
    private String denGyo;
    private String rhinCd;
    private String hinCd;
    private String hinNm;
    private String barasu;
    private String genTan;
    private String genKin;
    private String baiTan;
    private String baiKin;
    private String outFlg;
    private String insAt;
    private String updAt;
    private String stani;
    private String suryo;
    private String csvLine;
    private Integer lineNumber;
}
