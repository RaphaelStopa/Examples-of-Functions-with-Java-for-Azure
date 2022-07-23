package groupId.entities;


import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Order {

    private String id;

    @JsonProperty("operation_date")
    private String operationDate;
    
    @JsonProperty("inclusion_date")
    private String inclusionDate;



    @JsonProperty("code_anbima")
    private String codeAnbima;

    @JsonProperty("operation_value")
    private String operationValue;

    @JsonProperty("number_quotas")
    private String numberQuotas;

    @JsonProperty("settlement_type")
    private String settlementType;


    @JsonProperty("observations")
    private String observations;


    @JsonProperty("errors")
    private List<String> errors;

    @JsonProperty("id_origem")
    private String idOrigem;

    private boolean isChecked;

    @JsonProperty("user_id")
    private String userId;

    private boolean isPriorAuthorization;
    
    @JsonProperty("file_processed")
    private Boolean fileProcessed;
	

    
	@JsonProperty("liquidation_date")
	private String liquidationDate;
	
	@JsonProperty("quota_date")
	private String quotaDate;
	
	@JsonProperty("operating_quotas")
	private String operatingQuotas;
	
	@JsonProperty("withdraw_value")
	private String withdrawValue;

	@JsonProperty("code_denial_reason")
	private String codeDenialReason;

	@JsonProperty("cancel_description")
	private String cancelDescription;

	@JsonProperty("not_distribute_description")
	private String notDistributeDescription;

	@JsonProperty("reject_description")
	private String rejectDescription;

	private boolean originByScreen;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
