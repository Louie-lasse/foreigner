package com.java.springbootbackend.services.WasteBin;

import com.java.springbootbackend.model.WasteBin;

import java.util.List;

public interface IWasteBinService {
    List<WasteBin> getWasteBins();
}
