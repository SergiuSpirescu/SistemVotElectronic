package com.marjacu.sistemvotelectronic.Model.JSONHandler;

import com.marjacu.sistemvotelectronic.Model.VoteSessionContainer;
import com.marjacu.sistemvotelectronic.Model.VoteSession;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;


public class JsonReader {

    private static ObjectMapper mapper = new ObjectMapper();

    public static <VoteSession> void initSession(String dataSource, VoteSession session) throws IOException {


        File file = new File(dataSource);
        VoteSessionContainer container = mapper.readValue(file, VoteSessionContainer.class);
//        session.storeData(container);


        //TO-DO data integrity checks ?
//        session.setInitialized(true);
    }


}
