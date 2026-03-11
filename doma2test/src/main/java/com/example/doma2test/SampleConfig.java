package com.example.doma2test;

import com.example.doma2test.tasklet.DbInsertTasklet;
import com.example.doma2test.tasklet.ErrChkTasklet;
import com.example.doma2test.tasklet.InConvTasklet;
import com.example.doma2test.tasklet.MstGetTasklet;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class SampleConfig {
  @Autowired
  private InConvTasklet inConvTasklet;

  @Autowired
  private ErrChkTasklet errChkTasklet;

  @Autowired
  private MstGetTasklet mstGetTasklet;

  @Autowired
  private DbInsertTasklet dbInsertTasklet;

  @Bean
  Job sampleJob(JobRepository jobRepository, PlatformTransactionManager txManager) {
    Step inConvStep = new StepBuilder("inConvStep", jobRepository)
      .allowStartIfComplete(true)
      .tasklet(inConvTasklet, txManager)
      .build();

    Step errChkStep = new StepBuilder("errChkStep", jobRepository)
      .allowStartIfComplete(true)
      .tasklet(errChkTasklet, txManager)
      .build();

      Step mstGetStep = new StepBuilder("mstGetStep", jobRepository)
      .allowStartIfComplete(true)
      .tasklet(mstGetTasklet, txManager)
      .build();

      Step dbInsertStep = new StepBuilder("dbInsertStep", jobRepository)
        .allowStartIfComplete(true)
        .tasklet(dbInsertTasklet, txManager)
        .build();

    return new JobBuilder("sampleJob", jobRepository)
      .incrementer(new RunIdIncrementer())
      .start(inConvStep)
      .next(errChkStep)
      .next(mstGetStep)
      .next(dbInsertStep)
      .build();
  }
}