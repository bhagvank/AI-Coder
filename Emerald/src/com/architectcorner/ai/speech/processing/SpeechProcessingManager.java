/**
 * 
 */
package com.architectcorner.ai.speech.processing;

import java.io.FileInputStream;

import javax.sound.sampled.AudioFileFormat.Type;

import com.sun.speech.freetts.FreeTTS;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import com.sun.speech.freetts.audio.SingleFileAudioPlayer;

/**
 * @author bhagvan.kommadi
 *
 */
public class SpeechProcessingManager {

	public String getAudio(String text)
	{
		String fileName;
		
		System.setProperty("mbrola.base", "/Users/bhagvan.kommadi/desktop/voice/macos");
        VoiceManager voiceManager = VoiceManager.getInstance();
		
		Voice[] voices = voiceManager.getVoices();
		for(Voice voice:voices)
		{
			System.out.println(voice.getName()+" Domain "+voice.getDomain());
		}
		Voice voice = voiceManager.getVoice("kevin16");
		//System.setProperty("com.sun.speech.freetts.voice.defaultAudioPlayer", "com.sun.speech.freetts.audio.SingleFileAudioPlayer");
		
		FileInputStream fileInputStream;
		SingleFileAudioPlayer singleFileAudioPlayer;
		System.out.println(voice);
		voice.allocate();
		
		FreeTTS freeTTS = new FreeTTS(voice);
		
		//String text = new String("hello world");
		
		//byte bytes[] = text.getBytes();
		
		singleFileAudioPlayer = new SingleFileAudioPlayer("/Users/bhagvan.kommadi/desktop/voice",Type.WAVE);
		//singleFileAudioPlayer.write(bytes);
		
		voice.setAudioPlayer(singleFileAudioPlayer);
		voice.speak(text);
		
		fileName= "voice.wav";
		voice.deallocate();
		singleFileAudioPlayer.close();
		
		return fileName;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//System.setProperty("mbrola.base", "/Users/bhagvan.kommadi/desktop/voice/macos");
		
        VoiceManager voiceManager = VoiceManager.getInstance();
		
		Voice[] voices = voiceManager.getVoices();
		for(Voice voice:voices)
		{
			System.out.println(voice.getName()+" Domain "+voice.getDomain());
		}
		Voice voice = voiceManager.getVoice("kevin16");
		System.setProperty("com.sun.speech.freetts.voice.defaultAudioPlayer", "com.sun.speech.freetts.audio.SingleFileAudioPlayer");
		
		FileInputStream fileInputStream;
		SingleFileAudioPlayer singleFileAudioPlayer;
		System.out.println(voice);
		voice.allocate();
		
		FreeTTS freeTTS = new FreeTTS(voice);
		
		//String text = new String("hello world");
		
		//byte bytes[] = text.getBytes();
		
		singleFileAudioPlayer = new SingleFileAudioPlayer("/Users/bhagvan.kommadi/desktop/voice",Type.WAVE);
		//singleFileAudioPlayer.write(bytes);
		
		voice.setAudioPlayer(singleFileAudioPlayer);
		voice.speak("Thank you for giving me a voice.");
		
		voice.deallocate();
		singleFileAudioPlayer.close();
		
		
	}

}
