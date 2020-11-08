package com.muzu.explorer.service;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.util.Duration;

import java.io.File;

public class AudioService implements Service{
    private MusicService musicService = new MusicService();
    private MidiService midiService = new MidiService();
    private ServiceType currentServiceType = ServiceType.MUSIC;

    public AudioService() {
    }

    public void changeServiceToMusic(){
        currentServiceType = ServiceType.MUSIC;
    }

    public void changeServiceToMidi(){
        currentServiceType = ServiceType.MIDI;
    }

    @Override
    public void create(File file) {

    }

    @Override
    public void play() {
        if (currentServiceType == ServiceType.MUSIC){
            musicService.play();
        }
        else{
            midiService.play();
        }
    }

    @Override
    public void pause() {
        if (currentServiceType == ServiceType.MUSIC){
            musicService.pause();
        }
        else{
            midiService.pause();
        }
    }

    @Override
    public void stop() {
        if (currentServiceType == ServiceType.MUSIC){
            musicService.stop();
        }
        else{
            midiService.stop();
        }
    }

    @Override
    public Duration getDuration() {
        if (currentServiceType == ServiceType.MUSIC){
            return musicService.getDuration();
        }
        else{
            return midiService.getDuration();
        }
    }

    @Override
    public ReadOnlyObjectProperty<Duration> cycleDurationProperty() {
        if (currentServiceType == ServiceType.MUSIC){
            return musicService.cycleDurationProperty();
        }
        else{
            return midiService.cycleDurationProperty();
        }
    }

    @Override
    public ReadOnlyObjectProperty<Duration> totalDurationProperty() {
        if (currentServiceType == ServiceType.MUSIC){
            return musicService.totalDurationProperty();
        }
        else{
            return midiService.totalDurationProperty();
        }
    }

    @Override
    public ReadOnlyObjectProperty<Duration> currentTimeProperty() {
        if (currentServiceType == ServiceType.MUSIC){
            return musicService.currentTimeProperty();
        }
        else{
            return midiService.currentTimeProperty();
        }
    }

    @Override
    public void seek(Duration duration) {
        if (currentServiceType == ServiceType.MUSIC){
            musicService.seek(duration);
        }
        else{
            midiService.seek(duration);
        }
    }

    @Override
    public ObjectProperty<Runnable> onEndOfMediaProperty() {
        if (currentServiceType == ServiceType.MUSIC){
            return musicService.onEndOfMediaProperty();
        }
        else{
            return midiService.onEndOfMediaProperty();
        }
    }

    @Override
    public ObjectProperty<Runnable> onReadyProperty() {
        if (currentServiceType == ServiceType.MUSIC){
            return musicService.onReadyProperty();
        }
        else{
            return midiService.onReadyProperty();
        }
    }

    @Override
    public ObjectProperty<Runnable> onPlayingProperty() {
        if (currentServiceType == ServiceType.MUSIC){
            return musicService.onPlayingProperty();
        }
        else{
            return midiService.onPlayingProperty();
        }
    }

    @Override
    public ObjectProperty<Runnable> onPausedProperty() {
        if (currentServiceType == ServiceType.MUSIC){
            return musicService.onPausedProperty();
        }
        else{
            return midiService.onPausedProperty();
        }
    }

    @Override
    public ObjectProperty<Runnable> onStoppedProperty() {
        if (currentServiceType == ServiceType.MUSIC){
            return musicService.onStoppedProperty();
        }
        else{
            return midiService.onStoppedProperty();
        }
    }

    @Override
    public void dispose() {
        if (currentServiceType == ServiceType.MUSIC){
            musicService.dispose();
        }
        else{
            midiService.dispose();
        }
    }

    private enum ServiceType {
        MUSIC,
        MIDI
    }
}