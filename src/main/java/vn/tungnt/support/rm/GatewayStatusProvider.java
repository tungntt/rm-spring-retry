package vn.tungnt.support.rm;

import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author java dev be team on 2019-04-15
 * @project remote-manager
 */
@Service
public class GatewayStatusProvider {

    private Random rmStatus = new Random();

    public GatewayStatusDTO checkStatus() {
        GatewayStatusDTO dto = new GatewayStatusDTO();
        if (rmStatus.nextBoolean()) {
            dto.setStatus("ONLINE");
        } else {
            dto.setStatus("OFFLINE");
        }
        return dto;

    }
}

    