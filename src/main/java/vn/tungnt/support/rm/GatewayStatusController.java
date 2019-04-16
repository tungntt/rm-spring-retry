package vn.tungnt.support.rm;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author java dev be team on 2019-04-15
 * @project remote-manager
 */
@Slf4j
@RestController
public class GatewayStatusController {

    @Autowired
    private GatewayStatusProvider provider;

    private RandomDataGenerator rd;

    public GatewayStatusController() {
        this.rd = new RandomDataGenerator();
    }

    @GetMapping("gateway/{gwId}/status")
    public GatewayStatusDTO helpMeToCheck(@PathVariable("gwId") String gwId) throws InterruptedException {
        log.info("::: Received checking request from gateway {} :::", gwId);
        long delay = this.rd.nextLong(3000, 5000);
        Thread.sleep(delay);
        log.info("::: Delay request {} to {} milisecond: ", gwId, delay);
        return this.provider.checkStatus();
    }
}

    