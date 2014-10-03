/*
 * SoftViz3d Sonar plugin
 * Copyright (C) 2013 Stefan Rinderle
 * stefan@rinderle.info
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package de.rinderle.softviz3d.layout.calc;

import de.rinderle.softviz3d.tree.TreeNode;
import de.rinderle.softviz3d.tree.TreeNodeType;

public class LayeredLayoutElement {

    private TreeNodeType type;

    private Integer id;

    private String name;

    private Double width;
    private Double height;
    private Double buildingHeight;

    private String displayName;

    private LayeredLayoutElement(TreeNodeType type, Integer id, String name, Double width, Double height, Double buildingHeight, String displayName) {
        super();
        this.type = type;
        this.id = id;
        this.name = name;
        this.width = width;
        this.height = height;
        this.buildingHeight = buildingHeight;
        this.displayName = displayName;
    }

    public static LayeredLayoutElement createLayeredLayoutLeafElement(
            TreeNode node, Double width, Double height, Double buildingHeight) {
        return createLayeredLayoutElement("file_", node, width, height, buildingHeight);
    }

    public static LayeredLayoutElement createLayeredLayoutNodeElement(
            TreeNode node, Double width, Double height, Double buildingHeight) {
        return createLayeredLayoutElement("dir_", node, width, height, buildingHeight);
    }

    private static LayeredLayoutElement createLayeredLayoutElement(
            String namePrefix, TreeNode node, Double width, Double height, Double buildingHeight) {
        return new LayeredLayoutElement(node.getType(), node.getId(), namePrefix
                + node.getId().toString(), width, height,
                buildingHeight, node.getName());
    }

    public TreeNodeType getElementType() {
        return this.type;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public Double getWidth() {
        return width;
    }

    public Double getHeight() {
        return height;
    }

    public String getBuildingHeight() {
        return "x" + buildingHeight;
    }

    public String getDisplayName() {
        return displayName;
    }

}
