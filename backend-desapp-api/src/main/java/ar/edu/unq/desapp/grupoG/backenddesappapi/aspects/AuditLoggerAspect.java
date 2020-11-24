package ar.edu.unq.desapp.grupoG.backenddesappapi.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Aspect
@Component
public class AuditLoggerAspect {

    static Logger logger = LoggerFactory.getLogger(AuditLoggerAspect.class);

    /// ANNOTATION POINTCUT////
    @Around("@annotation(AuditLogger)")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("/-------------------Audit-Log-------------------------/");

        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;

        LocalDate anotherSummerDay = LocalDate.now();
        LocalTime anotherTime = LocalTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(anotherSummerDay, anotherTime, ZoneId.of("America/Argentina/Buenos_Aires"));

        logger.info("/////// " + "Executed in time: " + DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).format(zonedDateTime) + " ///////");
        logger.info("/////// " + joinPoint.getSignature() + " ///////");
        logger.info("/////// " + "Executed in " + executionTime + "ms" + " ///////");
        if(joinPoint.getArgs().length > 0){
            logger.info("/////// " + "Params" + " ///////");
            logger.info("/////// " + joinPoint.getArgs()[0].toString() + " ///////");
        }else{
            logger.info("/////// " + "No Params" + " ///////");
        }

        logger.info("/-----------------------------------------------------/");
        return proceed;
    }


}