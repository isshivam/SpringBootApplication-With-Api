package com.knoldus.springbootapplicationapi.services;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.Date;
    @Service
    public class ApplicationService {
        public static final long MSEC_SINCE_EPOCH = System.currentTimeMillis();
        public String getStatusWithTime(){
            Date instant = new Date( MSEC_SINCE_EPOCH );
            SimpleDateFormat sdf = new SimpleDateFormat( "HH:mm aa" );
            String time = sdf.format( instant );
            return "Running, "+ time;
        }
    }
