package com.anonymous.solar.desktop;

import java.io.File;

import javax.swing.filechooser.FileFilter;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.*;

/**
 * Filter to only select specially formatted ".ssu" files that contain a solar setup
 * @author Thura
 *
 */
public class SRUFilter extends FileFilter {

	@Override
	public boolean accept(File f) {
		if (f.isDirectory()) {
            return true;
        }
 
        String path = f.getPath();
        int lastOccurence = path.lastIndexOf('.');
        if(lastOccurence == -1){
        	return false;
        }
        String extension = path.substring(lastOccurence, path.length());
        
        if (extension != null) {
            if (extension.compareTo(".sru") == 0) {
                    return true;
            } else {
                return false;
            }
        }
 
        return false;
	}

	@Override
	public String getDescription() {
		return "Solar Result Configuration Filter";
	}

}
