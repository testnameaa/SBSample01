package com.example.doma2test.tasklet;

import java.util.List;

import com.example.doma2test.common.BatchConstants;
import com.example.doma2test.dao.JyuOrgDao;
import com.example.doma2test.dto.JyuOrgDto;
import com.example.doma2test.entity.JyuOrg;

import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.stereotype.Component;

@Component
public class DbInsertTasklet implements Tasklet {

    @Autowired
    private JyuOrgDao jyuOrgDao;

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        // Contextからデータを取得
        JobExecution jobExecution = chunkContext.getStepContext().getStepExecution().getJobExecution();
        @SuppressWarnings("unchecked")
        List<JyuOrgDto> stepDtoGet = (List<JyuOrgDto>) jobExecution.getExecutionContext().get(BatchConstants.CONTEXT_KEY_STEP_DTO);

        for (JyuOrgDto jyuOrgDto : stepDtoGet) {
            JyuOrg jyuOrg = new JyuOrg();
            jyuOrg.setJyuno(jyuOrgDto.getJyuno());
            jyuOrg.setToriCd(jyuOrgDto.getToriCd());
            jyuOrg.setToriNm(jyuOrgDto.getToriNm());
            jyuOrg.setBraCd(jyuOrgDto.getBraCd());
            jyuOrg.setBraNm(jyuOrgDto.getBraNm());
            jyuOrg.setHatDate(jyuOrgDto.getHatDate());
            jyuOrg.setSyuDate(jyuOrgDto.getSyuDate());
            jyuOrg.setNouDate(jyuOrgDto.getNouDate());
            jyuOrg.setDenNo(jyuOrgDto.getDenNo());
            jyuOrg.setTokCd(jyuOrgDto.getTokCd());
            jyuOrg.setTokNm(jyuOrgDto.getTokNm());
            jyuOrg.setUkebaCd(jyuOrgDto.getUkebaCd());
            jyuOrg.setSokCd(jyuOrgDto.getSokCd());
            jyuOrg.setSokNm(jyuOrgDto.getSokNm());
            jyuOrg.setHaisoCd(jyuOrgDto.getHaisoCd());
            jyuOrg.setHaisoNm(jyuOrgDto.getHaisoNm());
            jyuOrg.setDenGyo(jyuOrgDto.getDenGyo());
            jyuOrg.setRhinCd(jyuOrgDto.getRhinCd());
            jyuOrg.setHinCd(jyuOrgDto.getHinCd());
            jyuOrg.setHinNm(jyuOrgDto.getHinNm());
            jyuOrg.setBarasu(jyuOrgDto.getBarasu());
            jyuOrg.setGenTan(jyuOrgDto.getGenTan());
            jyuOrg.setGenKin(jyuOrgDto.getGenKin());
            jyuOrg.setBaiTan(jyuOrgDto.getBaiTan());
            jyuOrg.setBaiKin(jyuOrgDto.getBaiKin());
            jyuOrg.setOutFlg(jyuOrgDto.getOutFlg());
            jyuOrg.setInsAt(jyuOrgDto.getInsAt());
            jyuOrg.setUpdAt(jyuOrgDto.getUpdAt());

            jyuOrgDao.insert(jyuOrg);
        }
        return RepeatStatus.FINISHED;
    }
}
