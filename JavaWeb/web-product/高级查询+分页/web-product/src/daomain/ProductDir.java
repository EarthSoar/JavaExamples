package daomain;

import lombok.Data;

/**
 * @author Willing
 * @date 2019/1/8
 */
@Data
public class ProductDir {
    private Long id;
    private String dirName;
    private Long parent_id;
}
