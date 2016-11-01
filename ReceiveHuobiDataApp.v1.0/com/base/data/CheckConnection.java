package base.data;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckConnection {
	private static Logger logger = LoggerFactory.getLogger(DataReciever.class);

	public CheckConnection(DataReciever dataReciever) {
		this.dataReciever = dataReciever;
	}

	private DataReciever dataReciever;
	private ScheduledExecutorService connectMonitor = Executors.newScheduledThreadPool(1);

	public void check(final Object obj) {
		connectMonitor.scheduleWithFixedDelay(new Runnable() {
			
			public void run() {
				if ((!dataReciever.isConnected()) || (System.currentTimeMillis() - dataReciever.getLastTimeReceivedMessage()) > 60000) {
					logger.warn("socket.isdisconnect() ");
					try {
						dataReciever.disconnect();
					} catch (Exception e) {
						logger.warn("", e);
					}
					dataReciever.connectToSocketIO(obj);
				}
			}
		}, 60, 60, TimeUnit.SECONDS);
	}

}
