package com.architectcorner.ai.speech.recognition;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.File;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;

public class SpeechRecognitonManager {

	public static void main(String[] args) throws Exception
	{
		Configuration configuration = new Configuration();
		
		configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
		
		configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
		
		configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");
		
		StreamSpeechRecognizer streamSpeechRecognizer =  new StreamSpeechRecognizer(configuration);
		
		InputStream stream = new FileInputStream(new File("/Users/bhagvan.kommadi/desktop/voice/Ex2-7-adultmale-b_d/Exercise2.7_adultmale_b_d1.wav"));

		streamSpeechRecognizer.startRecognition(stream);

		SpeechResult result;
		
		while((result = streamSpeechRecognizer.getResult()) != null)
		{
			System.out.format("Hypothesis: %s\n",result.getHypothesis());
		}
		
		streamSpeechRecognizer.stopRecognition();
	}
}
