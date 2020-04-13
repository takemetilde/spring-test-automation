package com.org.config;

import org.junit.Assert;
import org.monte.media.Format;
import org.monte.media.FormatKeys;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.IOException;

import static org.monte.media.FormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

public class ScreenRecorderConfig {

    Format aviFileFormat = new Format(MediaTypeKey, FormatKeys.MediaType.FILE, MimeTypeKey, MIME_AVI);

    Format aviScreenFormat =
            new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                    CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                    DepthKey, 24, FrameRateKey, Rational.valueOf(15),
                    QualityKey, 1.0f,
                    KeyFrameIntervalKey, 15 * 60);

    Format aviMouseFormat = new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black",
            FrameRateKey, Rational.valueOf(30));

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    public ScreenRecorderConfig() {

    }

    public ScreenRecorder screenRecorder() {
        logger.info("Creating screen recorder...");
        ScreenRecorder screenRecorder;
        try {
            screenRecorder =
                    new ScreenRecorder(getDefaultGraphicsConfig());
            return screenRecorder;
        } catch (IOException | AWTException e) {
            Assert.fail("Recorder not set up.");
        }
        return null;
    }

    public GraphicsConfiguration getDefaultGraphicsConfig() {
        return GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getDefaultScreenDevice()
                .getDefaultConfiguration();
    }


}
