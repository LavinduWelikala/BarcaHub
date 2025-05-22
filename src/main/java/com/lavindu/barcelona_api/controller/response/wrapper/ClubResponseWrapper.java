package com.lavindu.barcelona_api.controller.response.wrapper;

import com.lavindu.barcelona_api.controller.response.ClubResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ClubResponseWrapper {

    private List<ClubResponse> clubList;
}
