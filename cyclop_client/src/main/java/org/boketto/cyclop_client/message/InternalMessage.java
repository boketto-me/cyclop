package org.boketto.cyclop_client.message;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InternalMessage {

    private Long messageId;

    private String messageNo;

    private String messageBody;

}
